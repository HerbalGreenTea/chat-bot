package org.bot.commands;

public class CommandsHandler {

    private final BotCommands botCommands = new BotCommands();

    public String handleCommand(String command) {
        return botCommands.getBotCommands().get(command).execute();
    }

    public Boolean isBotCommand(String commandName) {
        return botCommands.getCommandNames().contains(commandName);
    }
}
