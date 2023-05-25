package academy.dates.test;

import java.util.Calendar;
import java.util.Date;

public class CalendarTest01 {
    public static void main(String[] args) {
        //Calendar c = new Calendar(); Nao da pra fazer isso pois esse calendar é abstrato.
        Calendar c = Calendar.getInstance(); //Pega uma instancia do calendar e coloca na variavel de referencia c.
        if (c.getFirstDayOfWeek() == Calendar.SUNDAY) {  //Em alguns países o domingo ou é primeiro dia ou é ultimo dia da semana. Pra saber como está definido aqui faz isso.
            System.out.println("Domingao do faustoao é o primeiro dia da semana");
        }

        Date date = c.getTime(); // Vc pega o dia de hj dessa forma, pois o c sozinho tem um formato complicado.
        System.out.println(date);

        System.out.println("-------------------");

        System.out.println(c.get(Calendar.DAY_OF_WEEK));  //Usando as constantes vc pode pegar coisas úteis.
        System.out.println(c.get(Calendar.DAY_OF_MONTH));
        System.out.println(c.get(Calendar.DAY_OF_WEEK_IN_MONTH));
        System.out.println(c.get(Calendar.DAY_OF_YEAR));

        System.out.println("-------------------");

        c.add(Calendar.DAY_OF_MONTH, 2); //Adicionando dois dias na data de hj.
        c.roll(Calendar.HOUR, 3); //Com o roll vc adiciona tempo sem virar o dia, quando passa de 24 hrs ele volta pro 0 no mesmo dia.

        Date date2 = c.getTime();
        System.out.println(date2);
    }
}
