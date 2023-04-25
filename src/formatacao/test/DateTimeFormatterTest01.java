package formatacao.test;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class DateTimeFormatterTest01 {  //Toda vez que vc escuta a palavra format, vc esta transformando do objeto pra uma string. Quando escuta parse, da string pro objeto.
    public static void main(String[] args) {
        LocalDate date = LocalDate.now();
        String s1 = date.format(DateTimeFormatter.BASIC_ISO_DATE); //O datetimeformatter tem varios tipos de formatacao q vc usa dessa forma.
        String s2 = date.format(DateTimeFormatter.ISO_DATE);
        String s3 = date.format(DateTimeFormatter.ISO_LOCAL_DATE);
        System.out.println(s1);
        System.out.println(s2);
        System.out.println(s3);
        //Agora ao contrario
        LocalDate parse1 = LocalDate.parse("20230424", DateTimeFormatter.BASIC_ISO_DATE); //Vc coloca o formato que vai parsear, se nao da erro.
        System.out.println(parse1);
        LocalDate parse2 = LocalDate.parse("2023-04-24+05:00", DateTimeFormatter.ISO_DATE); //Vc pode colocar a hora a mais no ISO_DATE pq ele suporta offset. 
        System.out.println(parse2);
        LocalDate parse3 = LocalDate.parse("2023-04-24", DateTimeFormatter.ISO_LOCAL_DATE); 
        System.out.println(parse3);
        System.out.println("-------------------------");
        LocalDateTime now = LocalDateTime.now();
        String s4 = now.format(DateTimeFormatter.ISO_DATE_TIME);
        System.out.println(s4);
        LocalDateTime parse4 = LocalDateTime.parse("2023-04-24T10:02:47.0844529", DateTimeFormatter.ISO_DATE_TIME);
        System.out.println(parse4);
        System.out.println("-------------------------");

        //Para criar formatos
        DateTimeFormatter formatterBr = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String formatBR = LocalDate.now().format(formatterBr);
        System.out.println(formatBR + " Formato do BRAZILLLLLLL!!");
        LocalDate parseBR = LocalDate.parse("24/04/2023", formatterBr);
        System.out.println(parseBR); //O mesmo valor mas agora tipo LocalDate.
        System.out.println("-------------------------");

        DateTimeFormatter formatterGR = DateTimeFormatter.ofPattern("dd.MMMM.yyyy", Locale.GERMAN);
        String formatGR = LocalDate.now().format(formatterGR);
        System.out.println(formatGR + " Alemaozada!!");
        LocalDate parseGR = LocalDate.parse("24.April.2023", formatterGR);
        System.out.println(parseGR);  //O mesmo valor mas agora tipo LocalDate.


    }
}
