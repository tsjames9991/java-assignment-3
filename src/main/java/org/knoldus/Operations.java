package org.knoldus;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;

/**
 * Operations Class.
 */
public class Operations {
    /**
     * Total seconds in a day.
     */
    private final int toSeconds = 24 * 60 * 60;
    /**
     * ONE: private final ONE.
     */
    private final int one = 1;

    /**
     * Return list of day of weeks from given date until today's date.
     *
     * @param birthday : user's birthday.
     * @return : List of week names.
     */
    public final List<String> getDayOfWeek(final LocalDate birthday) {
        LocalDate today = LocalDate.now();
        List<String> result = new ArrayList<>();
        LocalDate givenBirthday = birthday;
        while (givenBirthday.isBefore(today)) {
            result.add(givenBirthday.getDayOfWeek().name());
            givenBirthday = givenBirthday.plusYears(one);
        }
        return result;
    }

    /**
     * gets current time from the given zone.
     *
     * @param timeZone : user specific time zone.
     * @param time : current time.
     * @return : current time.
     */
    public final String getTimeFromTimeZone(final String timeZone,
                                      final LocalDateTime time) {
        ZoneId zone = ZoneId.of(timeZone);
        return time.atZone(zone).toString();
    }

    /**
     * find the number of seconds Gandhi lived.
     *
     * @return : returns seconds.
     */
    public final long mahtmaGandhiLived() {
        LocalDate birth = LocalDate.parse("1869-10-02");
        LocalDate demise = LocalDate.parse("1948-01-30");
        return birth.until(demise, ChronoUnit.DAYS) * toSeconds;
    }

    /**
     * Returns all the leap year between year 1990 to 2018.
     *
     * @return : List of years.
     */
    public final List<Integer> listLeapYears() {
        LocalDate firstLeap = LocalDate.parse("1990-01-01");
        LocalDate currentDate = LocalDate.now();
        List<Integer> years = new ArrayList<Integer>();

        while (firstLeap.isBefore(currentDate)) {
            if (firstLeap.isLeapYear()) {
                years.add(firstLeap.getYear());
            }
            firstLeap = firstLeap.plusYears(one);
        }
        return years;
    }
}
