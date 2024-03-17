import java.math.BigDecimal;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.ArrayList;

public class Exercise05 {

    // THE GODMOTHER
    // ========================
    // Complete the numbered tasks below.
    // Open and execute the accompanying tests to confirm your solution is correct.

    // 1. Your Godmother gives you $10 every other Friday throughout the year.
    // Payments start on the first Friday of the year.
    // Given a date, calculate payments expected from that date until the end of the year.
    BigDecimal calculateGiftsTilEndOfYear(LocalDate date) {
        ArrayList<LocalDate> everyOtherFriday = getEveryOtherFridayForYear(date.getYear());

        // 3. For every other Friday, add a gift if the Friday is after the provided date...

        BigDecimal totalGiftAmount = BigDecimal.ZERO;

        for (LocalDate f : everyOtherFriday) {
            if (f.compareTo(date) >= 0) {
                totalGiftAmount = totalGiftAmount.add(BigDecimal.TEN);
            }
        }

        return totalGiftAmount;
    }

    private ArrayList<LocalDate> getEveryOtherFridayForYear(int year) {
        LocalDate startOfTheYear = LocalDate.of(year, 1, 1);
        LocalDate endOfTheYear = LocalDate.of(year, 12, 31);

        // 1. Find the first Friday of the year...
        LocalDate friday = findFirstFriday(startOfTheYear);

        // 2. Build a collection of every other Friday starting from the first Friday of the year...

        ArrayList<LocalDate> everyOtherFriday = new ArrayList<>();
        while (friday.compareTo(endOfTheYear) <= 0) {
            everyOtherFriday.add(friday);
            friday = friday.plusWeeks(2);
        }
        return everyOtherFriday;
    }

    /**
     * Returns the first Friday from the provided date.
     * @param date The date to start from.
     * @return The first Friday.
     */
    private LocalDate findFirstFriday(LocalDate date) {
        LocalDate friday = date.plusDays(0);

        // Go forward until we reach the first Friday...
        while (friday.getDayOfWeek() != DayOfWeek.FRIDAY) {
            friday = friday.plusDays(1);
        }

        return friday;
    }

    // 2. Your Godmother is getting quirky. She adjusted her payment schedule.
    // She still pays every other Friday throughout the year, starting on the first Friday of the year.
    // But now, she pays a number of dollars equal to the day of the month.
    // Examples
    // Jan 31 == $31
    // Mar 1 == $1
    // July 12 == $12
    // Given a date, calculate payments expected from that date until the end of the year.
    BigDecimal calculateQuirkyGiftsTilEndOfYear(LocalDate date) {
        ArrayList<LocalDate> everyOtherFriday = getEveryOtherFridayForYear(date.getYear());

        // 3. For every other Friday, add a gift if the Friday is after the provided date...

        BigDecimal totalGiftAmount = BigDecimal.ZERO;

        for (LocalDate f : everyOtherFriday) {
            if (f.compareTo(date) >= 0) {
                totalGiftAmount = totalGiftAmount.add(new BigDecimal(f.getDayOfMonth()));
            }
        }

        return totalGiftAmount;
    }

}
