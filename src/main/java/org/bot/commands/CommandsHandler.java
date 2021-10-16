package org.bot.commands;

import org.bot.ChatBotPreference;

public class CommandsHandler {

    private final BotCommands botCommands;

    public CommandsHandler(ChatBotPreference chatBotPreference) {
        botCommands = new BotCommands(chatBotPreference);
    }

    public String handleCommand(String command) {
        return botCommands.getBotCommands().get(command).execute();
    }

    public Boolean isBotCommand(String commandName) {
        return botCommands.getCommandNames().contains(commandName);
    }
}
