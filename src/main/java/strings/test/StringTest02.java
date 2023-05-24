package strings.test;

public class StringTest02 {
    public static void main(String[] args) { //Métodos
        String nome = "   Luffy  ";
        String numeros = "01234567";
        System.out.println(nome.charAt(0));
        System.out.println(nome.length()); //A diferença de lenght de array e de string é que a de array é um atributo (nao tem ()) e a de string é um método
        System.out.println(nome.replace("f", "l"));
        System.out.println(numeros.substring(0, 4));//O endIndex é exclusivo, sempre retorna um a menos do que colocou.
        System.out.println(numeros.substring(3, numeros.length())); //Uma forma de pegar de algum numero até o fim da string. Se vc omitir o segundo argumento da na mesma.
        System.out.println(nome.trim()); //Remove os whitespaces do começo e do fim da string.
    }
}
