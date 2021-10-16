package org.bot.commands;

import org.bot.ChatBotPreference;
import org.bot.services.TypeService;

public record SelectTranslationServiceBotCommand(
        ChatBotPreference chatBotPreference
) implements IBotCommand {

    @Override
    public String getCommandName() {
        return "\\translation";
    }

    @Override
    public String getCommandDescription() {
        return "запустить сервис перевода слов";
    }

    @Override
    public String execute() {
        chatBotPreference.selectTypeService(TypeService.TRANSLATION_SERVICE);

        return "";
    }
}
