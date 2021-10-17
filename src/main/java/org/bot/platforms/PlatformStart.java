package org.bot.platforms;

import org.bot.platforms.telegram.ChatBotTelegram;
import org.bot.user.User;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;

public class PlatformStart {
    public static void start(TypePlatform typePlatform, User user) {
        switch (typePlatform) {
            case CONSOLE -> {

            }
            case TELEGRAM -> {
                try {
                    TelegramBotsApi botsApi = new TelegramBotsApi(DefaultBotSession.class);
                    var chatBot = new ChatBotTelegram(
                            user,
                            "LearningLanguageEnglishBot",
                            "2004830155:AAGrzXPOUXBg-s6dITz8KfAzkp-bmsByt4A"
                    );
                    botsApi.registerBot(chatBot);
                } catch (TelegramApiException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
