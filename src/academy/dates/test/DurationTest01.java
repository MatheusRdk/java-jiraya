package academy.dates.test;

import java.time.Duration;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class DurationTest01 {  //Ajuda a ver a diferença entre tempo (segundos minutos horas). Ela nao aceita LocalDate pq nao tem segundos.
    public static void main(String[] args) {    //Depois do PT começa o tempo, dai antes do H é hora, do M minutos, e assim por diante.
        LocalDateTime now = LocalDateTime.now();
        LocalDateTime nowAfterTwoYears = LocalDateTime.now().plusYears(2);
        LocalTime timeNow = LocalTime.now();
        LocalTime timeMinus7Hours = LocalTime.now().minusHours(7);
        Duration d1 = Duration.between(now, nowAfterTwoYears);
        Duration d2 = Duration.between(timeNow, timeMinus7Hours);
        Duration d3 = Duration.between(Instant.now(), Instant.now().plusSeconds(1000));
        Duration d4 = Duration.ofDays(365); //Ele da a representaçao de 20 dias em horas.


        System.out.println(d1);
        System.out.println(d2);
        System.out.println(d3);
        System.out.println(d4);

    }
}
