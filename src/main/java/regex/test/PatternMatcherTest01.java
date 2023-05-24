package regex.test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PatternMatcherTest01 {
    public static void main(String[] args) {
        String regex = "aba";
        String texto = "abaabababa";    //o matcher nao pega mais de uma vez a letra se ela ja foi utilizada no ultimo match
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(texto);
        System.out.println("texto:  " + texto);
        System.out.println("indice: 0123456789");
        System.out.println("regex:  " + regex);
        System.out.println("Posições encontradas");
        while (matcher.find()){
            System.out.print(matcher.start() + " ");
        }

    }
}
