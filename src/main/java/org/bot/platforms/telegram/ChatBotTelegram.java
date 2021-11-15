package org.bot.platforms.telegram;

import org.bot.platforms.ChatPlatform;
import org.bot.user.User;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardRow;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import java.util.ArrayList;
import java.util.Collections;

public class ChatBotTelegram extends TelegramLongPollingBot implements ChatPlatform<SendMessage, Update> {

    private final User currentUser;
    private final String botUsername;
    private final String botToken;
    private final ReplyKeyboardMarkup replykeyboardMarkup;

    private Update message;

    public ChatBotTelegram(User currentUser, String botUsername, String botToken) {
        this.currentUser = currentUser;
        this.botUsername = botUsername;
        this.botToken = botToken;
        replykeyboardMarkup = new ReplyKeyboardMarkup();
    }

    @Override
    public void onUpdateReceived(Update update) {

        if (update.hasMessage() && update.getMessage().hasText()) {
            message = update;
        }

        var userMessage = outputMessage();

        if (userMessage != null) {
            SendMessage sendMessage = new SendMessage();
            sendMessage.setChatId(userMessage.getMessage().getChatId().toString());

            var sendMessages = currentUser.getUserSession().handleUserMessage(getMessage(userMessage.getMessage().getText()));
            sendMessage.setReplyMarkup(replykeyboardMarkup);

            for (String message: sendMessages) {
                sendMessage.setText(message);
                inputMessage(sendMessage);
            }
        }
    }

    @Override
    public String getBotUsername() {
        return botUsername;
    }

    @Override
    public String getBotToken() {
        return botToken;
    }

    @Override
    public void inputMessage(SendMessage message) {
        try {
            execute(message);
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Update outputMessage() {
        return message;
    }

    private String getMessage(String message) {
        var keyboard = new ArrayList<KeyboardRow>();
        var firstKeyboardRow = new KeyboardRow();
        var secondKeyboardRow = new KeyboardRow();
        var thirdKeyboardRow = new KeyboardRow();
        replykeyboardMarkup.setSelective(true);
        replykeyboardMarkup.setResizeKeyboard(true);
        replykeyboardMarkup.setOneTimeKeyboard(false);

        var helpMessage = "Помощь❔";
        var statisticMessage = "Статистика \uD83D\uDCBE";
        var translateMessage = "Переводить слова \uD83D\uDD8B";
        firstKeyboardRow.add(translateMessage);
        secondKeyboardRow.add(statisticMessage);
        thirdKeyboardRow.add(helpMessage);
        addRowsInKeyboard(keyboard, firstKeyboardRow, secondKeyboardRow, thirdKeyboardRow);
        replykeyboardMarkup.setKeyboard(keyboard);

        if (message.equals((helpMessage))) {
            return "\\help";
        }

        if (message.equals(translateMessage)) {
            return "\\translation";
        }

        if (message.equals(statisticMessage)) {
            return "\\stat";
        }

        return message;
    }

    private void addRowsInKeyboard(ArrayList<KeyboardRow> keyboard, KeyboardRow ... rows) {
        Collections.addAll(keyboard, rows);
    }
}
