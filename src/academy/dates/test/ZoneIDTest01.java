package academy.dates.test;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.OffsetDateTime;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.util.Map;

public class ZoneIDTest01 {
    public static void main(String[] args) {
        Map<String, String> shortIds = ZoneId.SHORT_IDS; //Mapa (chave, valor) das zonas disponíveis nesse ZoneId
        System.out.println(shortIds);
        System.out.println("----------------");
        System.out.println(ZoneId.systemDefault());
        ZoneId tokyoZone = ZoneId.of("Asia/Tokyo");
        System.out.println(tokyoZone);
        System.out.println("----------------");
        LocalDateTime now = LocalDateTime.now(); //O padrao do localdatetime nao tem zona, ai vc adiciona com o atZone.
        ZonedDateTime zonedDateTime = now.atZone(tokyoZone); //Vc precisa atribuir ele a uma variavel, que agora pra incluir zona é uma ZonedDateTIme
        System.out.println(zonedDateTime);
        System.out.println("----------------");
        
        Instant nowInstant = Instant.now();
        ZonedDateTime zonedDateTime2 = nowInstant.atZone(tokyoZone);
        System.out.println(zonedDateTime2);  //A diferença pro instant é que ele ja traz aplicado o horário. No Datetime normal ele só apareceu +09:00, dizendo que em tokyo o horario é mais 9hrs.
        System.out.println("----------------");

        //Offset. Serve pra vc adicionar uma diferença de horário manualmente. Ex.: vc ve no windows que manaus tem o horario -4h.
        System.out.println(ZoneOffset.MAX); //Maximo e minimo que vc pode adicionar ou subtrair dos horários.
        System.out.println(ZoneOffset.MIN);
        ZoneOffset offsetManaus = ZoneOffset.of("-04:00");  //Vc primeiro cria o offset
        OffsetDateTime offsetDateTime = now.atOffset(offsetManaus); // Depois adiciona ao horario que ja tem, agora tendo como objeto de referencia um OffsetDateTime
        System.out.println(offsetDateTime);  //Ele so mostra o offset no horario (-04:00). Se vc fizer com o instant ele já muda a hora.
        OffsetDateTime offsetDateTime2 = OffsetDateTime.of(now, offsetManaus);  //Outra forma de fazer ja criando em uma linha.
        System.out.println(offsetDateTime2);

    }
}