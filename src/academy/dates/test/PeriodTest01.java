package academy.dates.test;

import java.time.LocalDate;
import java.time.Period;

public class PeriodTest01 {
    public static void main(String[] args) {//Parecido com o Duration mas em vez de horas e minutos trabalha com datas. Mostra em dias meses e anos
        LocalDate now = LocalDate.now();
        LocalDate nowAfterTwoYears = LocalDate.now().plusYears(2).plusDays(6);
        Period p1 = Period.between(now, nowAfterTwoYears);
        Period p2 = Period.ofDays(150); //Retorna em dias
        Period p3 = Period.ofWeeks(70);
        Period p4 = Period.ofMonths(20);


        System.out.println(p1);
        System.out.println(p2);
        System.out.println(p3);
        System.out.println(p4);

        
    }
}
