package regex.test;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PatternMatcherTest05 {
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
        // ^ = começo de linha ou negaçao. Tudo o que nao for abc = [^abc]


        String regex = "([a-zA-Z0-9\\._-])+@([a-zA-Z])+(\\.([a-zA-Z])*)*";
        String texto = "luffy@hotmail.com, jotaro123@gmail.com, @#%%zoro@mail.br, teste@gmail.com.br, sakura@mail ";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(texto);
        System.out.println("texto:  " + texto);
        System.out.println("indice: 0123456789");
        System.out.println("regex:  " + regex);
        System.out.println("Posições encontradas");
        while (matcher.find()){
            System.out.print(matcher.start() + " " + matcher.group() + "\n");  //O group mostra o que ele achou e o start a posição.
        }


        System.out.println("Email válido:");
        System.out.println("zoro@mail.br".matches(regex)); //Uma forma de colocar uma string e ver se ela bate com a regex
        System.out.println(Arrays.toString(texto.split(","))); //Aqui vc separou cada coisa por virgula, transformando cada um em uma posiçao de um array
        System.out.println(texto.split(",")[2].trim());  //Aqui vc seleciona os itens por posiçao e usa o trim pra tirar os espços em branco
    }
}