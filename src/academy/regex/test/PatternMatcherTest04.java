package academy.regex.test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PatternMatcherTest04 {
    public static void main(String[] args) {
        // \d = Todos os dígitos
        // \D = Tudo o que nao for dígito.
        // \s = espaços em branco \t \n \f \r
        // \S = Tudo menos espaço em branco
        // \w = a-zA-z, dígitos, _
        // \W = tudo que nao for incluso no \w
        // [] = procura qualquer coisa que esteja dentro dos colchetes
        // ? = Zero ou 1 ocorrência
        // * = Zero ou mais ocorrências
        // + = Uma ou mais ocorrências
        // {n, m} = De n a m ocorrências
        // () = agrupamento
        // | = ou
        // $ = fim da linha
        // . = tudo

        String regex = "0[xX]([a-fA-F\\d])+(\\s|$)";  //no fim significa que as letras e numeros sao seguidas ou de um espaço em branco ou fim de linha
        String texto = "0x 12 0x14D2 0X 0xBBA 0X10G 0x1";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(texto);
        System.out.println("texto:  " + texto);
        System.out.println("indice: 0123456789");
        System.out.println("regex:  " + regex);
        System.out.println("Posições encontradas");
        while (matcher.find()){
            System.out.print(matcher.start() + " " + matcher.group() + "\n");  //O group mostra o que ele achou e o start a posição.
        }
    }
}