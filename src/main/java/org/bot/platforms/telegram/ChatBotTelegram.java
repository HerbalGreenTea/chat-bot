package org.bot.platforms.telegram;

import org.bot.platforms.ChatPlatform;
import org.bot.user.User;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

public class ChatBotTelegram extends TelegramLongPollingBot implements ChatPlatform<SendMessage, Update> {

    private final User currentUser;
    private final String botUsername;
    private final String botToken;

    private Update message;

    public ChatBotTelegram(User currentUser, String botUsername, String botToken) {
        this.currentUser = currentUser;
        this.botUsername = botUsername;
        this.botToken = botToken;
    }

    @Override
    public void onUpdateReceived(Update update) {

        if (update.hasMessage() && update.getMessage().hasText()) {
            message = update;
        }

        var userMessage = outputMessage();

        if (userMessage != null) {
            SendMessage sendMessage = new SendMessage();
            sendMessage.setChatId(update.getMessage().getChatId().toString());

            var sendMessages = currentUser.getUserSession().handleUserMessage(update.getMessage().getText());

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
}
