package org.bot.statistics;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class TimeInAppStatistics implements IStatistics {

    private final Calendar timeStartSession;
    private int hours;
    private int minutes;

    public TimeInAppStatistics(Calendar timeStartSession) {
        this.timeStartSession = timeStartSession;
    }

    @Override
    public void createStatistics() {
        var currentTime = new GregorianCalendar();
        hours = Math.abs(timeStartSession.get(Calendar.HOUR) - currentTime.get(Calendar.HOUR));
        minutes = Math.abs(timeStartSession.get(Calendar.MINUTE) - currentTime.get(Calendar.MINUTE));
    }

    @Override
    public String getTextFormatStatistics() {
        createStatistics();
        return String.format(
                "%d часов %d минут проведено в приложении",
                hours,
                minutes
        );
    }
}
