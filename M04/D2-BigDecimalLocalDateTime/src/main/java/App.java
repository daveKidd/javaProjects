import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.*;
import java.time.format.DateTimeFormatter;

public class App {
    public static void main(String[] args) {
        // Oct 26th 1985  ---  Marty meet Doc at the mall
        LocalDate date = LocalDate.of(1985, 10, 26);
        LocalDate today = LocalDate.now();

        LocalTime marty1955time = LocalTime.of(6,15);
        LocalTime martyArrived = LocalTime.of(8,29);
        Duration difference = Duration.between(marty1955time,martyArrived);
        System.out.printf("It took Marty %s hours | %s minutes to get downtown.  Total: %s seconds%n",
                difference.toHoursPart(), difference.toMinutesPart(), difference.getSeconds());

        LocalDateTime martyReturns = LocalDateTime.of(1985,10,26,1,24);
        DateTimeFormatter martyFormat = DateTimeFormatter.ofPattern("MMMM d, yyyy 'at' h:mm a");
        System.out.println(martyReturns.format(martyFormat));


//        LocalDate marty1955past = date.minusYears(30).plusDays(10);
//        LocalTime marty1955time = LocalTime.of(6,15);
//        System.out.printf("Marty's new date in the past is now %s %s %s, %s at %s:%s",
//                marty1955past.getDayOfWeek(),marty1955past.getMonth(),
//                marty1955past.getDayOfMonth(),marty1955past.getYear(),
//                marty1955time.getHour(),marty1955time.getMinute());
//
//        Period sinceMartyJumped = date.until(today);
//        System.out.printf("%nIt's been %s years | %s months | %s days since Marty jumped to the past",
//                sinceMartyJumped.getYears(),sinceMartyJumped.getMonths(),sinceMartyJumped.getDays());

//        System.out.println(date.isAfter(today));
//        System.out.println(date.isBefore(today));
//        LocalDate yesterday = today.minusDays(1);
//        System.out.println(yesterday);
//
//        System.out.println(date.getDayOfWeek());
//        System.out.println(date.getDayOfYear());
//        System.out.println(date.isLeapYear());
//        System.out.println(today.getYear());



        // BIG DECIMAL EXAMPLES
//        BigDecimal gigawatts = new BigDecimal(1210000000);
//        BigDecimal panelwatts = new BigDecimal(380.26);
//        System.out.println(gigawatts.divide(panelwatts,2,RoundingMode.HALF_UP));


        //        BigDecimal a = new BigDecimal("1.25");
//        BigDecimal b = new BigDecimal(1.30);
//        b = b.setScale(2, RoundingMode.HALF_EVEN);
//        System.out.println(b.subtract(a));

        //BigDecimal a = new BigDecimal("1.25");
//        BigDecimal b = new BigDecimal("1.30");
//        System.out.println(b.subtract(a));
//
//        double x = 1.25;
//        double y = 1.30;
//        System.out.println(y-x);
    }
}
