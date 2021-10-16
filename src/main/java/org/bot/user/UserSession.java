package org.bot.user;

import org.bot.ChatBotPreference;
import org.bot.commands.CommandsHandler;
import org.bot.services.IServiceBot;
import org.bot.services.ServiceFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class UserSession {

    private final ChatBotPreference chatBotPreference;
    private final CommandsHandler commandsHandler;
    private final ServiceFactory serviceFactory;

    private IServiceBot currentService;

    public UserSession() {
        this.chatBotPreference = new ChatBotPreference();
        this.commandsHandler = new CommandsHandler(chatBotPreference);
        this.serviceFactory = new ServiceFactory();
        this.currentService = serviceFactory.createService(chatBotPreference.getSelectedTypeService());
    }


    public List<String> handleUserMessage(String message) {
        var response = new ArrayList<String>();

        if (commandsHandler.isBotCommand(message)) {
            // TODO ваще не прикольно, как миниум должна возвращаться не строка а какой-то класс с дежнериком
            // но это тоже не очень то работает (класс с дженериком)
            var commandResult = commandsHandler.handleCommand(message);

            if (!commandResult.isBlank()) {
                response.add(commandResult);
            }

            if (currentService.getServiceType() != chatBotPreference.getSelectedTypeService()) {
                currentService = serviceFactory.createService(chatBotPreference.getSelectedTypeService());
                response.add(currentService.getMessageForUser());
            }

        } else {
            response.add(currentService.processUserMessage(message));

            // TODO придумать чонть получше
            if (!Objects.equals(currentService.getMessageForUser(), ""))
                response.add(currentService.getMessageForUser());
        }

        return response;
    }
}
