package org.bot;

import org.bot.statistics.StatisticsInteractor;
import org.bot.user.UserPreference;
import toothpick.config.Module;

public class GlobalModule extends Module {

    public GlobalModule() {
        UserPreference userPreference = new UserPreference();
        bind(UserPreference.class).toInstance(userPreference);

        StatisticsInteractor statisticsInteractor = new StatisticsInteractor();
        bind(StatisticsInteractor.class).toInstance(statisticsInteractor);
    }
}
