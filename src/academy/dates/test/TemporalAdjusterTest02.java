package academy.dates.test;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.temporal.ChronoField;
import java.time.temporal.ChronoUnit;
import java.time.temporal.Temporal;
import java.time.temporal.TemporalAdjuster;          //Com o temporal adjuster, vc cria a logica que quiser dentro do adjustInto. É uma interface que vc usa pra criar o método que precisar.
  
class ObterProximoDiaUtil implements TemporalAdjuster{     //Mostra o próximo dia útil. 

    @Override
    public Temporal adjustInto(Temporal temporal) {
        DayOfWeek day = DayOfWeek.of(temporal.get(ChronoField.DAY_OF_WEEK));
        int addDays;

        switch (day){
            case FRIDAY: addDays = 3;
            break;
            case SATURDAY: addDays = 2;
            break;
            default: addDays = 1;
        }

        return temporal.plus(addDays, ChronoUnit.DAYS);
    }

}

public class TemporalAdjusterTest02 {
    public static void main(String[] args) {
        LocalDate now = LocalDate.now();
        System.out.println(now);
        System.out.println(now.getDayOfWeek());

        now = LocalDate.now().with(new ObterProximoDiaUtil());
        System.out.println(now);
        System.out.println(now.getDayOfWeek());

        now = LocalDate.now().withDayOfMonth(18).with(new ObterProximoDiaUtil());
        System.out.println(now);
        System.out.println(now.getDayOfWeek());

    }
}
