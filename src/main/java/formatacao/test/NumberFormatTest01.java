package formatacao.test;

import java.text.NumberFormat;
import java.util.Locale;

public class NumberFormatTest01 {
    public static void main(String[] args) {

        Locale localePT = new Locale("pt", "BR");
        Locale localeIT = Locale.ITALY; //Alguns países ja tem a constante deles e da pra acessar dessa forma.
        Locale localeCA = Locale.CANADA;
        NumberFormat[] nfa = new NumberFormat[3];
        nfa[0] = NumberFormat.getInstance(localePT);
        nfa[1] = NumberFormat.getInstance(localeCA);
        nfa[2] = NumberFormat.getInstance(localeIT);
        double valor = 10_000.2130;
        for (NumberFormat numberFormat : nfa) {
            System.out.println(numberFormat.format(valor));
        }
    }
}
