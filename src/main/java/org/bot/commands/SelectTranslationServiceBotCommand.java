package org.bot.commands;

import org.bot.Main;
import org.bot.services.TypeService;
import org.bot.user.UserPreference;
import toothpick.Scope;
import toothpick.Toothpick;

import javax.inject.Inject;

public class SelectTranslationServiceBotCommand implements IBotCommand {

    @Inject
    UserPreference userPreference;

    public SelectTranslationServiceBotCommand() {
        Scope global = Toothpick.openScope(Main.NAME_GLOBAL_SCOPE);
        Toothpick.inject(this, global);
    }

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
