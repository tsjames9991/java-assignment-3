package org.knoldus;

import org.junit.Test;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

/**
 * Test suite designed for Operations.java.
 */

public class OperationsTest {
    /**
     * Operations Object.
     */
    private static final Operations OPERATION = new Operations();
    /**
     * List of leap years.
     */
    private static final List<Integer> LEAPYEAR = new ArrayList<>();
    /**
     * Total seconds Gandhi lived.
     */
    private static final long SECONDS = 2471731200L;
    /**
     * Leap years between 1990 to 2018.
     */
    private static final int ONE = 1992;
    /**
     * Leap years between 1990 to 2018.
     */
    private static final int TWO = 1996;
    /**
     * Leap years between 1990 to 2018.
     */
    private static final int THREE = 2000;
    /**
     * Leap years between 1990 to 2018.
     */
    private static final int FOUR = 2004;
    /**
     * Leap years between 1990 to 2018.
     */
    private static final int FIVE = 2008;
    /**
     * Leap years between 1990 to 2018.
     */
    private static final int SIX = 2012;
    /**
     * Leap years between 1990 to 2018.
     */
    private static final int SEVEN = 2016;

    /**
     * checks how many seconds Mahatma Gandhi lived.
     */
    @Test
    public final void testMahtmaGandhiLived() {
        assertEquals("Mahatma Gandhi lived in seconds should match",
                OPERATION.mahtmaGandhiLived(),
                SECONDS);
    }

    /**
     * to check list days of week of birthdays.
     */
    @Test
    public final void testGetDayOfWeeks() {
        LocalDate birthDay = LocalDate.parse("1991-09-09");
        String[] actualResult = OPERATION
                .getDayOfWeek(birthDay).toArray(new String[0]);
        String[] expectedResult = new String[]{"MONDAY", "WEDNESDAY",
                "THURSDAY", "FRIDAY", "SATURDAY", "MONDAY", "TUESDAY",
                "WEDNESDAY", "THURSDAY", "SATURDAY", "SUNDAY", "MONDAY",
                "TUESDAY", "THURSDAY", "FRIDAY", "SATURDAY", "SUNDAY",
                "TUESDAY", "WEDNESDAY", "THURSDAY", "FRIDAY", "SUNDAY",
                "MONDAY", "TUESDAY", "WEDNESDAY", "FRIDAY", "SATURDAY"};
        assertArrayEquals("days of week of birthdays should match",
                expectedResult, actualResult);
    }

    /**
     * checks leap years from 1990 to 2018.
     */
    @Test
    public final void testGetLeapYears() {
        int[] actualResult = OPERATION.listLeapYears().stream()
                .mapToInt(x -> x)
                .toArray();
        LEAPYEAR.add(ONE);
        LEAPYEAR.add(TWO);
        LEAPYEAR.add(THREE);
        LEAPYEAR.add(FOUR);
        LEAPYEAR.add(FIVE);
        LEAPYEAR.add(SIX);
        LEAPYEAR.add(SEVEN);
        int[] expectedResult = LEAPYEAR.stream()
                .mapToInt(x -> x)
                .toArray();
        assertArrayEquals("leap years should match",
                expectedResult, actualResult);
    }

    /**
     * getting time from time zone.
     */
    @Test
    public final void testGetTimeFromTimeZone() {
        LocalDateTime current = LocalDateTime.now();
        String actualResult = OPERATION.getTimeFromTimeZone("UTC+12", current);
        ZoneId zone = ZoneId.of("UTC+12");
        String expectedResult = current.atZone(zone).toString();
        assertEquals("UTC time should be equal", expectedResult, actualResult);
    }

}
