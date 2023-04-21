package dates.test;

import java.time.Instant;
import java.time.LocalDateTime;

public class InstantTest01 {
    public static void main(String[] args) {
        Instant now = Instant.now();
        System.out.println(now); //O Z que aparece no final do horario do instant se refere ao Zulu time (tipo utc), que é um horário neutro.
        System.out.println(LocalDateTime.now());

        System.out.println(now.getEpochSecond());
        System.out.println(now.getNano()); //em 1 seg vc tem quase 999.999.999 de nanoseg
    }
}