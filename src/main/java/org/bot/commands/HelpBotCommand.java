package org.bot.commands;

public record HelpBotCommand(
        BotCommands botCommands
) implements IBotCommand{

    // TODO возможно не очень хорошо, что команда знает о всех командах

    @Override
    public String getCommandName() {
        return "\\help";
    }

    @Override
    public String getCommandDescription() {
        return "описывает возможности бота и работы с ним";
    }

    @Override
    public String execute() {
        var helpMessage = new StringBuilder();

        for (IBotCommand command : botCommands.getBotCommands().values()) {
            helpMessage.append(command.getCommandName());
            helpMessage.append(" - ");
            helpMessage.append(command.getCommandDescription());
            helpMessage.append("\n");
        }

        return helpMessage.toString();
    }
}
