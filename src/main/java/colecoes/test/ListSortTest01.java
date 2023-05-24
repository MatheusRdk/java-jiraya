package colecoes.test;

import colecoes.dominio.Manga;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ListSortTest01 {
    public static void main(String[] args) {
//        List<String> mangas = new ArrayList<>(6);
//        mangas.add("Vc conhece PICOLO?");
//        mangas.add("Narruto");
//        mangas.add("Dragon Ball");        //Se forem strings, o sort funciona de primeira.
//        mangas.add("Magin Bu");
//        mangas.add("Attack on TI");
        List<Manga> mangas = new ArrayList<>(6);
        mangas.add(new Manga(5L, "Vc conhece PICOLO?", 668.2));
        mangas.add(new Manga(1L, "Narruto", 245.3));
        mangas.add(new Manga(2L, "Dragon Ball", 367));
        mangas.add(new Manga(7L, "Magin Bu", 622));
        mangas.add(new Manga(4L, "Attack on TI",667.32));

        //Collections é uma classe com vários métodos estáticos utilitários. Ele vai dar certo no manga se vc implementar o método do compareTo na classe.
        for (Manga manga : mangas){
            System.out.println(manga);
        }
        System.out.println("------______-------______------_____-----____----___--__");
        Collections.sort(mangas); //La no compareTo foi definido que seria sortado por id. Mas pode ser pelas outras coisas também.
        for (Manga manga : mangas){
            System.out.println(manga);
        }

        //Se vc fizer um sort de strings, integers, Doubles, beleza, mas se for usar sort nos smartphones por exemplo, vai dar erro, pois nem o java nem vc definiu como organizar eles.
        //Por isso vc vai e implementa o método compareTo do Comparable
    }
}
