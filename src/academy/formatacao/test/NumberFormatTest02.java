package academy.formatacao.test;

import java.text.NumberFormat;
import java.text.ParseException;
import java.util.Locale;

public class NumberFormatTest02 {
    public static void main(String[] args) {

        Locale localePT = new Locale("pt", "BR");
        Locale localeIT = Locale.ITALY; //Alguns países ja tem a constante deles e da pra acessar dessa forma.
        Locale localeCA = Locale.CANADA;
        NumberFormat[] nfa = new NumberFormat[3];
        nfa[0] = NumberFormat.getCurrencyInstance(localePT);
        nfa[1] = NumberFormat.getCurrencyInstance(localeCA);
        nfa[2] = NumberFormat.getCurrencyInstance(localeIT);
        double valor = 1000.213;
        for (NumberFormat numberFormat : nfa) {
            numberFormat.setMaximumFractionDigits(2); //Setando o numero depois da virgula
            System.out.println(numberFormat.format(valor));
        }

        String val = "$1,000.21"; // Se vc usar o parse com um valor com caracteres diferentes como o _, ele vai parar de fazer o parse quando chegar nele. ParseException: Unparseable number: "10_000"
        try {
            System.out.println(nfa[1].parse(val)); //Vc usa a formatacao de valor do pais certo, pra ele converter a string para o numero ja formatado para o pais.
        } catch (ParseException e) {
            e.printStackTrace();
        }

    }
}
