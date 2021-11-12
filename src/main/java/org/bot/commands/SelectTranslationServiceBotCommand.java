package org.bot.commands;

import org.bot.services.TypeService;
import org.bot.user.UserPreference;

public record SelectTranslationServiceBotCommand(
        UserPreference userPreference
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
        userPreference.selectTypeService(TypeService.TRANSLATION_SERVICE);

        return "";
    }
}
