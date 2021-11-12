package org.bot.commands;

import org.bot.Main;
import org.bot.statistics.StatisticsInteractor;
import toothpick.Scope;
import toothpick.Toothpick;

import javax.inject.Inject;

public class GetStatisticsBotCommand implements IBotCommand {

    @Inject
    StatisticsInteractor statisticsInteractor;

    public GetStatisticsBotCommand() {
        Scope global = Toothpick.openScope(Main.NAME_GLOBAL_SCOPE);
        Toothpick.inject(this, global);
    }

    @Override
    public String getCommandName() {
        return "\\stat";
    }

    @Override
    public String getCommandDescription() {
        return "выдает статистику о пользователе";
    }

    @Override
    public String execute() {
        return statisticsInteractor.getAllStatistics();
    }
}
