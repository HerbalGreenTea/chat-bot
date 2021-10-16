package org.bot.telegram;

import org.bot.user.User;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

public class ChatBotTelegram extends TelegramLongPollingBot {

    private final User currentUser;
    private final String botUsername;
    private final String botToken;

    public ChatBotTelegram(User currentUser, String botUsername, String botToken) {
        this.currentUser = currentUser;
        this.botUsername = botUsername;
        this.botToken = botToken;
    }

    @Override
    public void onUpdateReceived(Update update) {

        if (update.hasMessage() && update.getMessage().hasText()) {
            SendMessage message = new SendMessage();
            message.setChatId(update.getMessage().getChatId().toString());

            var messages = currentUser.getUserSession().handleUserMessage(update.getMessage().getText());

            for (int i = 0; i < messages.size(); i++) {
                message.setText(messages.get(i));
                try {
                    execute(message); // Call method to send the message
                } catch (TelegramApiException e) {
                    e.printStackTrace();
                }
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
}
