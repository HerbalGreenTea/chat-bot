package org.bot.commands;

public interface IBotCommand {
    String getCommandName();

    String getCommandDescription();

    String execute();
}
