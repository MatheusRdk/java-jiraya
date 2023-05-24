package colecoes.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ListaArrayConversaoTest01 {
    public static void main(String[] args) {
        List<Integer>numeros = new ArrayList<>();
        numeros.add(1);
        numeros.add(2);
        numeros.add(3);
        System.out.println("List: " + numeros);
        Integer[] listToArray = numeros.toArray(new Integer[0]);//O jeito indicado a fazer é passando 0 no tamanho, que o java se encarrega de achar o tamanho certo.
        System.out.println("Array: " + Arrays.toString(listToArray));

        System.out.println("----------------------------------------");

        Integer[] numerosArray = new Integer[3];
        numerosArray[0] = 1;
        numerosArray[1] = 2;
        numerosArray[2] = 3;
        List<Integer> arrayToList = Arrays.asList(numerosArray);
        arrayToList.set(0, 16);  //Perceba que isso mudou o primeiro valor tanto da lista quanto do array. O método asList cria um link entre o array e a lista, pode ser problemático
        //arrayToList.add(20);  //Tanto que vc vc tentar adicionar pelo add vai dar exceção.
        System.out.println("Array: " + Arrays.toString(numerosArray));
        System.out.println("List: " + arrayToList);

        System.out.println("----------------------------------------");
        List<Integer> numerosList = new ArrayList<>(Arrays.asList(numerosArray)); //Desse jeito aqui é o certo, assim nao existe mais o vínculo que existia daquela forma.
        numerosList.add(200);
        System.out.println(numerosList);

        List<String> stringList = List.of("1", "2", "6"); //Forma de criar a lista do zero em uma linha com valores.
        System.out.println(stringList);


    }
}
