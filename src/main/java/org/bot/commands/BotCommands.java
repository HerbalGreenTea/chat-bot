package org.bot.commands;

import org.bot.ChatBotPreference;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BotCommands {

    private final List<IBotCommand> botCommands;

    public BotCommands(ChatBotPreference chatBotPreference) {
        // TODO надо подумать
        botCommands = new ArrayList<>();
        {
            botCommands.add(new HelpBotCommand(this));
            botCommands.add(new SelectTranslationServiceBotCommand(chatBotPreference));
        }
    }

    public List<String> getCommandNames() {
        var commandNames = new ArrayList<String>();

        for (var command : botCommands) {
            commandNames.add(command.getCommandName());
        }

        return commandNames;
    }

    public Map<String, IBotCommand> getBotCommands() {
        var commands = new HashMap<String, IBotCommand>();

        for (var command : botCommands) {
            commands.put(command.getCommandName(), command);
        }

        return commands;
    }
}
