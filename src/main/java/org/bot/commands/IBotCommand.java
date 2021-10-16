package org.bot.commands;

public interface IBotCommand {
    //todo: это две сущности
    String getCommandName();

    String getCommandDescription();

    String execute();
}
