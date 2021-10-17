package org.bot.commands;

import org.bot.statistics.StatisticsInteractor;
import org.bot.user.UserPreference;

public class CommandsHandler {

    private final BotCommands botCommands;

    public CommandsHandler(UserPreference userPreference, StatisticsInteractor statisticsInteractor) {
        botCommands = new BotCommands(userPreference, statisticsInteractor);
    }

    public String handleCommand(String command) {
        return botCommands.getBotCommands().get(command).execute();
    }

    public Boolean isBotCommand(String commandName) {
        return botCommands.getCommandNames().contains(commandName);
    }
}
