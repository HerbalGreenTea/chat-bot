package org.bot.user;

import org.bot.Main;
import org.bot.commands.CommandsHandler;
import org.bot.services.IServiceBot;
import org.bot.services.ServiceFactory;
import org.bot.statistics.StatisticsInteractor;
import toothpick.Scope;
import toothpick.Toothpick;

import javax.inject.Inject;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class UserSession {

    @Inject
    UserPreference userPreference;

    private final CommandsHandler commandsHandler;
    private final ServiceFactory serviceFactory;
    private final StatisticsInteractor statisticsInteractor;

    private IServiceBot currentService;

    public UserSession() {
        Scope global = Toothpick.openScope(Main.NAME_GLOBAL_SCOPE);
        Toothpick.inject(this, global);
        this.statisticsInteractor = new StatisticsInteractor();
        this.commandsHandler = new CommandsHandler(userPreference, statisticsInteractor);
        this.serviceFactory = new ServiceFactory(userPreference);
        this.currentService = serviceFactory.createService(userPreference.getSelectedTypeService());
    }


    public List<String> handleUserMessage(String message) {
        var response = new ArrayList<String>();

        if (commandsHandler.isBotCommand(message)) {
            var commandResult = commandsHandler.handleCommand(message);

            if (!commandResult.isBlank()) {
                response.add(commandResult);
            }

            if (currentService.getServiceType() != userPreference.getSelectedTypeService()) {
                currentService = serviceFactory.createService(userPreference.getSelectedTypeService());
                response.add(currentService.getMessageForUser());
            }

        } else {
            response.add(currentService.processUserMessage(message));

            if (!Objects.equals(currentService.getMessageForUser(), ""))
                response.add(currentService.getMessageForUser());
        }

        return response;
    }
}
