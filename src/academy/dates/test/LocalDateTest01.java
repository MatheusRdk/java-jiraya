package academy.dates.test;

import java.time.LocalDate;
import java.time.Month;
import java.time.temporal.ChronoField;

public class LocalDateTest01 {
    public static void main(String[] args) {//LocalDate é melhor que as primeiras, dateformat e tudo essas, pois é mais simples e atual. Foi introduzida no Java 8. Usar sempre essa
        LocalDate date = LocalDate.of(2021, Month.APRIL, 11);
        LocalDate agora = LocalDate.now(); //Pegar uma instancia de agora
        System.out.println(date.getDayOfMonth());
        System.out.println(date.getDayOfWeek());
        System.out.println(date.getMonth());
        System.out.println(date.isLeapYear()); //Se e ano bissexto
        System.out.println(date.get(ChronoField.DAY_OF_WEEK));


        System.out.println(agora); //A formatacao padrao do LocalDate ja é de uma forma bem usada por banco de dados.
        System.out.println(LocalDate.MAX); //Data maxima que pode ser utilizada
        System.out.println(LocalDate.MIN); //Data minima
        
    }
}
