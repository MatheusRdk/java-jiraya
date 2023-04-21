package dates.test;

import java.time.LocalDateTime;
import java.time.Month;
import java.time.temporal.ChronoUnit;

public class ChronoUnitTest01 {
    public static void main(String[] args) {
        LocalDateTime aniversario = LocalDateTime.of(1999, Month.AUGUST, 19, 15, 0, 0);
        System.out.println(ChronoUnit.DAYS.between(aniversario, LocalDateTime.now()));
        System.out.println(ChronoUnit.MONTHS.between(aniversario, LocalDateTime.now()));
        System.out.println(ChronoUnit.WEEKS.between(aniversario, LocalDateTime.now()));


    }
}
