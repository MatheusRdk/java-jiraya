package academy.dates.test;

import java.time.LocalTime;
import java.time.temporal.ChronoField;

public class LocalTimeTest01 {
    public static void main(String[] args) {
        LocalTime time = LocalTime.of(23, 25, 9);
        LocalTime hora = LocalTime.now();
        System.out.println(time + " " + hora);
        System.out.println(hora.getHour());
        System.out.println(hora.getMinute());
        System.out.println(hora.getNano());
        System.out.println(hora.get(ChronoField.SECOND_OF_DAY));
        System.out.println(LocalTime.MAX); //23:59
        System.out.println(LocalTime.MIN);

    }   
}
