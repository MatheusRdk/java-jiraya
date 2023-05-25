package academy.dates.test;

import java.util.Date;

public class DateTest01 {
    public static void main(String[] args) {
        Date date = new Date(1681914346534L); //Quase nao é usado esse date, pois é dos sistemas legados. Mas é importante caso mexa com um sistema legado, abaixo do java 7.
        //O date em ms dessa classe Date representa todas as datas em ms desde 1970.
        System.out.println(date); //O tempo no date é em ms, e o sout converte pra uma forma legível com o to.String(). Para printar com o numero em ms mesmo, usa date.getTime().
        System.out.println(date.getTime()); //Desse jeito vc pega o dia de hj em ms.
    }
}
