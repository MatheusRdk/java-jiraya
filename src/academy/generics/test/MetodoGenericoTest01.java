package academy.generics.test;

import academy.generics.dominio.Barco;

import java.util.List;

public class MetodoGenericoTest01 {
    public static void main(String[] args) {
        List<Barco> barcoList = criarArrayComUmObjeto(new Barco("Barcocô"));
        System.out.println(barcoList);
    }

    private static <T> List<T> criarArrayComUmObjeto (T t) { //No método genérico vc coloca o <T> dessa forma. Essa está retornando um list do que vc passar
        //Na linha de cima, basicamente o primeiro T depois do static diz o delimita o T que pode ser passado. Ai está só T, mas poderia ser T extends Comparable<? super T> por ex.
        //List<T> list = List.of(t); //Aqui vc esta fazendo uma lista do objeto t (Barco(T, variavel referencia) = new Barco(t, objeto))
        return List.of(t); //Ou vc retorna direto a lista de t, quando o retorno do método é uma lista.
    }
}
