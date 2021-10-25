package org.bot.statistics;

import java.util.Calendar;
import java.util.GregorianCalendar;

public record TimeInAppStatistics(
        Calendar timeStartSession
) implements IStatistics {
    @Override
    public String getStatistics() {
        var currentTime = new GregorianCalendar();
        var hours = Math.abs(timeStartSession.get(Calendar.HOUR) - currentTime.get(Calendar.HOUR));
        var minutes = Math.abs(timeStartSession.get(Calendar.MINUTE) - currentTime.get(Calendar.MINUTE));
        return String.format(
                "%d часов %d минут проведено в приложении",
                hours,
                minutes
        );
    }
}
