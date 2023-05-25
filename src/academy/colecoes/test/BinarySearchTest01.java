package academy.colecoes.test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BinarySearchTest01 {
    public static void main(String[] args) {
        List<Integer> numeros = new ArrayList<>();
        numeros.add(5);
        numeros.add(4);
        numeros.add(1);
        numeros.add(39);
        numeros.add(52);
        // (-(ponto de inserção)-1). Essa é a lógica que o binarySearch usa para retornar um número quando ele não existe na tua lista. Ponto de inserção seria o lugar que o número
        //                                                                                      voltaria caso ele estivesse ali, por ex.: se tivesse o 2 ele seria no index 3.
        //                                                                                   Isso garante que se um número existir dentro de sua lista ele retorna um valor positivo,
        //                                                                                   e se não existir retorna um valor negativo.
        Collections.sort(numeros); //Para fazer o binarySearch a lista precisa estar sortada.
        System.out.println(Collections.binarySearch(numeros, 44));


    }
}
