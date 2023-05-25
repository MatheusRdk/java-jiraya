package academy.regex.test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PatternMatcherTest02 {
    public static void main(String[] args) {
        // \d = Todos os dígitos
        // \D = Tudo o que nao for dígito.
        // \s = espaços em branco \t \n \f \r
        // \S = Tudo menos espaço em branco
        // \w = a-zA-z, dígitos, _
        // \W = tudo que nao for incluso no \w

        String regex = "\\d";
        String texto = "abaabababa";
        String texto2 = "asjkd123123nklj23890";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(texto2);
        System.out.println("texto:  " + texto2);
        System.out.println("indice: 0123456789");
        System.out.println("regex:  " + regex);
        System.out.println("Posições encontradas");
        while (matcher.find()){
            System.out.print(matcher.start() + " " + matcher.group() + "\n");  //O group mostra o que ele achou e o start a posição.
        }
    }
}