package org.bot;


import org.bot.telegram.ChatBotTelegram;
import org.bot.user.User;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;

public class Main {

    public static void main(String[] args) {
        var user = new User();

        try {
            TelegramBotsApi botsApi = new TelegramBotsApi(DefaultBotSession.class);
            botsApi.registerBot(new ChatBotTelegram(user, "", ""));
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }
}
