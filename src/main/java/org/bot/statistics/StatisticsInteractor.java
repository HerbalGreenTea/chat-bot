package org.bot.statistics;

import org.bot.user.UserPreference;

import java.util.ArrayList;
import java.util.List;

public class StatisticsInteractor {

    private List<IStatistics> statistics;

    public StatisticsInteractor(UserPreference userPreference) {
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
            dataStat.append(statistic.getStatistics());
            dataStat.append("\n");
        }
        return dataStat.toString();
    }
}
