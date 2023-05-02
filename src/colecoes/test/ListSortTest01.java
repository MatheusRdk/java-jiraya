package colecoes.test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ListSortTest01 {
    public static void main(String[] args) {
        List<String> mangas = new ArrayList<>(6);
        mangas.add("Vc conhece PICOLO?");
        mangas.add("Narruto");
        mangas.add("Dragon Ball");
        mangas.add("Magin Bu");
        mangas.add("Attack on TI");
        Collections.sort(mangas); //Collections é uma classe com vários métodos estáticos utilitários.
        for (String manga : mangas){
            System.out.println(manga);
        }
        System.out.println("------______-------______------_____-----____----___--__");
        System.out.println(mangas);

        //Se vc fizer um sort de strings, integers, Doubles, beleza, mas se for usar sort nos smartphones por exemplo, vai dar erro, pois nem o java nem vc definiu como organizar eles.

    }
}
