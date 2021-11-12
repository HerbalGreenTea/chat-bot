package org.bot.commands;

import org.bot.statistics.StatisticsInteractor;

public record GetStatisticsBotCommand(StatisticsInteractor statisticsInteractor) implements IBotCommand {
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
