package org.bot.statistics;

import org.bot.user.UserPreference;

import java.util.Calendar;
import java.util.GregorianCalendar;

// Todo добавить возможность работать сразу с нексколькими словарями
public record StatisticsInteractor(UserPreference userPreference) {

    public String getAllStatistics() {
        return getTimeInApp() + "\n" + getTranslatedWords();
    }

    public String getTimeInApp() {
        var currentTime = new GregorianCalendar();
        var hours = Math.abs(userPreference.getTimeStartSession().get(Calendar.HOUR) - currentTime.get(Calendar.HOUR));
        var minutes = Math.abs(userPreference.getTimeStartSession().get(Calendar.MINUTE) - currentTime.get(Calendar.MINUTE));
        return String.format(
                "%d часов %d минут проведено в приложении",
                hours,
                minutes
        );
    }

    public String getTranslatedWords() {
        var correctlyWords = userPreference.getLexicalDictionary().getCorrectlyTranslatedWords();
        var incorrectlyWords = userPreference.getLexicalDictionary().getIncorrectlyTranslatedWords();

        return String.format(
                "верно переведно %d слов\nне верно переведено %d слов",
                correctlyWords.size(),
                incorrectlyWords.size()
        );
    }
}
