package org.bot.user;

import org.bot.GlobalFileLogger;
import org.bot.Main;
import org.bot.commands.CommandsHandler;
import org.bot.services.IServiceBot;
import org.bot.services.ServiceFactory;
import toothpick.Scope;
import toothpick.Toothpick;

import javax.inject.Inject;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class UserSession {

    @Inject
    UserPreference userPreference;
    @Inject
    GlobalFileLogger globalFileLogger;

    private final CommandsHandler commandsHandler = new CommandsHandler();
    private final ServiceFactory serviceFactory = new ServiceFactory();

    private IServiceBot currentService = serviceFactory.createService();

    public UserSession() {
        Scope global = Toothpick.openScope(Main.NAME_GLOBAL_SCOPE);
        Toothpick.inject(this, global);
        globalFileLogger.logInfo("init user session");
    }

    public List<String> handleUserMessage(String message) {
        var response = new ArrayList<String>();

        if (commandsHandler.isBotCommand(message)) {
            var commandResult = commandsHandler.handleCommand(message);
            globalFileLogger.logInfo("execute command " + message);

            if (!commandResult.isBlank()) {
                response.add(commandResult);
            }

            if (currentService.getServiceType() != userPreference.getSelectedTypeService()) {
                currentService = serviceFactory.createService();
                response.add(currentService.getMessageForUser());
            }

        } else {
            response.add(currentService.processUserMessage(message));

            if (!Objects.equals(currentService.getMessageForUser(), ""))
                response.add(currentService.getMessageForUser());

            globalFileLogger.logInfo("user message " + message);
        }

        return response;
    }
}
