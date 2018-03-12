package org.knoldus;

import java.time.LocalDate;

public class Application {
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

        System.out.println("Getting all the days of week from birthday to today");
        operations.getDayOfWeek(birthday).forEach(System.out::println);

        System.out.println("Getting current time according to the timezone");
        System.out.println(operations.getTimeFromTimeZone("UTC+12"));
        System.out.println(operations.getTimeFromTimeZone("UTC"));

        System.out.println("Listing all the leap years from 1990 - 2018");
        operations.listLeapYears()
                .forEach(System.out::println);

        System.out.println("Mahatma Gandhi was alive for : ");
        System.out.println(operations.mahtmaGandhiLived() + " seconds");
    }
}
