package org.knoldus;

import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * Application Class.
 */
public final class Application {
    /**
     * Nobody must implement this class.
     */
    private Application() {

    }

    /**
     * Entry point of application.
     *
     * @param args : console line arguments
     */
    public static void main(final String[] args) {
        Operations operations = new Operations();
        LocalDate birthday = LocalDate.parse("1991-09-09");

        System.out.println("Get all the days of week from birthday to today");
        operations.getDayOfWeek(birthday).forEach(System.out::println);

        System.out.println("Getting current time according to timezone");
        System.out.println(operations.
                getTimeFromTimeZone("UTC", LocalDateTime.now()));
        System.out.println(operations.
                getTimeFromTimeZone("UTC+12", LocalDateTime.now()));

        System.out.println("List all the leap years from 1990 - 2018");
        operations.listLeapYears()
                .forEach(System.out::println);

        System.out.println("Mahatma Gandhi was alive for : ");
        System.out.println(operations.mahtmaGandhiLived() + " seconds");
    }
}
