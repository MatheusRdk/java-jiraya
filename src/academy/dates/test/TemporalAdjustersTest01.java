package academy.dates.test;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.temporal.ChronoField;
import java.time.temporal.TemporalAdjusters;

public class TemporalAdjustersTest01 {
    public static void main(String[] args) {
        LocalDate now = LocalDate.now();
        LocalDate now2 = LocalDate.now();

        now = now.withMonth(5); //Os metodos with permitem mudar a data como quiser.
        now2 = now2.with(ChronoField.DAY_OF_MONTH, 30); 

        System.out.println(now);
        System.out.println(now2);

        System.out.println(now.getDayOfWeek());
        System.out.println(now2.getDayOfWeek());
        System.out.println("------------------------");

        now = LocalDate.now().with(TemporalAdjusters.nextOrSame(DayOfWeek.SUNDAY)); //Saber qual o proximo domingo.
        System.out.println(now);
        System.out.println(now.getDayOfWeek());

        now = LocalDate.now().with(TemporalAdjusters.next(DayOfWeek.SUNDAY));
        System.out.println(now);
        System.out.println(now.getDayOfWeek());

        now = LocalDate.now().with(TemporalAdjusters.previous(DayOfWeek.SUNDAY));
        System.out.println(now);
        System.out.println(now.getDayOfWeek());

        now = LocalDate.now().with(TemporalAdjusters.firstDayOfMonth());
        System.out.println(now);
        System.out.println(now.getDayOfWeek());

        now = LocalDate.now().with(TemporalAdjusters.lastDayOfMonth());
        System.out.println(now);
        System.out.println(now.getDayOfWeek());

        now = LocalDate.now().with(TemporalAdjusters.firstDayOfNextYear());
        System.out.println(now);
        System.out.println(now.getDayOfWeek());

    }
}
