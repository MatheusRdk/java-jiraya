package academy.dates.test;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class LocalDateTimeTest01 {
    public static void main(String[] args) {  //Uma junçao do LocalDate e LocalTime e tem praticamente tudo que elas tem.
        LocalDateTime localDateTime = LocalDateTime.now();
        LocalDate date = LocalDate.parse("2025-09-09");
        LocalTime time = LocalTime.parse("07:54:28");
        LocalDateTime ldt1 = date.atTime(time); //Essa data NA hora (date ATtime time). Aqui vc tem um dia e adicionou uma hora;
        LocalDateTime ldt2 = time.atDate(date); // Essa hora na data. Aqui vc tem uma hora e adicionou um dia.

        System.out.println(localDateTime);
        System.out.println(ldt1);
        System.out.println(ldt2);



    }   
}
