package org.knoldus;

import java.time.LocalDate;
import java.time.ZonedDateTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;
import java.util.TimeZone;

public class Operations {
    private final int toSeconds = 60 * 60 * 60;
    /**
     * ONE: private final ONE resembles unity.
     */
    private final int one = 1;

    /**
     * Return list of day of weeks from given date until today's date.
     *
     * @param birthday : user's birthday.
     * @return : List of week names.
     */
    public List<String> getDayOfWeek(final LocalDate birthday) {
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
     * @return : current time.
     */
    public String getTimeFromTimeZone(final String timeZone) {
        TimeZone zone = TimeZone.getTimeZone(timeZone);
        return ZonedDateTime.now(zone.toZoneId()).toString();
    }

    /**
     * find the number of seconds Gandhi lived.
     *
     * @return : returns seconds.
     */
    public long mahtmaGandhiLived() {
        LocalDate birth = LocalDate.parse("1869-10-02");
        LocalDate demise = LocalDate.parse("1948-01-30");
        return birth.until(demise, ChronoUnit.DAYS) * toSeconds;
    }

    /**
     * Returns all the leap year between year 1990 to 2018.
     *
     * @return : List of years.
     */
    public List<Integer> listLeapYears() {
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
