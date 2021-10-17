package org.bot.statistics;

import org.bot.dictionaries.EnglishRussianDictionary;
import org.bot.dictionaries.ILexicalDictionary;
import org.bot.user.UserPreference;

// Todo добавить возможность рабоать сразу с нексколькими словарями
public class StatisticsInteractor {

    private final UserPreference userPreference;
    private final ILexicalDictionary engToRussDict;

    public StatisticsInteractor(UserPreference userPreference) {
        this.userPreference = userPreference;
        this.engToRussDict = new EnglishRussianDictionary();
    }

    public String getAllStatistics() {
        return null;
    }
}
