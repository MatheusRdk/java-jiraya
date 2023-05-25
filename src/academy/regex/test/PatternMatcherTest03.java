package academy.regex.test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PatternMatcherTest03 {
    public static void main(String[] args) {
        // \d = Todos os dígitos
        // \D = Tudo o que nao for dígito.
        // \s = espaços em branco \t \n \f \r
        // \S = Tudo menos espaço em branco
        // \w = a-zA-z, dígitos, _
        // \W = tudo que nao for incluso no \w
        // []


        //String regex = "[a-zA-C]";
        String regex = "0[xX][a-fA-F\\d]";
        //String texto = "abaabababa";
        String texto2 = "0x 12 0x14D2 0X 0xBBA 0X109 0x1";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(texto2);
        System.out.println("texto:  " + texto2);
        System.out.println("indice: 0123456789");
        System.out.println("regex:  " + regex);
        System.out.println("Posições encontradas");
        while (matcher.find()){
            System.out.print(matcher.start() + " " + matcher.group() + "\n");  //O group mostra o que ele achou e o start a posição.
        }

        int numeroHex = 0X109;  //Para o java reconhecer um numero hexadecimal vc coloca 0x ou 0X na frente. O hex so pode ter letra até F
        System.out.println(numeroHex);
    }
}