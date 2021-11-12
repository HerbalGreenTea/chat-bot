package org.bot.statistics;

import org.bot.Main;
import org.bot.user.UserPreference;
import toothpick.Scope;
import toothpick.Toothpick;

import javax.inject.Inject;
import java.util.ArrayList;
import java.util.List;

public class StatisticsInteractor {

    private final List<IStatistics> statistics;

    @Inject
    UserPreference userPreference;

    public StatisticsInteractor() {
        Scope global = Toothpick.openScope(Main.NAME_GLOBAL_SCOPE);
        Toothpick.inject(this, global);
        this.statistics = new ArrayList<>();
        {
            statistics.add(new TimeInAppStatistics(userPreference.getTimeStartSession()));
            statistics.add(new TranslatedWordsStatistics(userPreference.getLexicalDictionary()));
            statistics.add(new LearnedAndUnlearnedWordsStatistics(userPreference.getLexicalDictionary()));
        }
    }

    public String getAllStatistics() {
        var dataStat = new StringBuilder();
        for (IStatistics statistic : statistics) {
            dataStat.append(statistic.getTextFormatStatistics());
            dataStat.append("\n");
        }
        return dataStat.toString();
    }
}
