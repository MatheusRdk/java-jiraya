package colecoes.test;

import colecoes.dominio.Manga;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class SetTest01 {
    public static void main(String[] args) {
        Set<Manga> mangas = new HashSet<>(); //HashSet é uma coleçao que permite apenas elementos únicos os quais são organizados pelo hash.
        mangas.add(new Manga(5L, "Vc conhece PICOLO?", 668.2, 0));
        mangas.add(new Manga(1L, "Narruto", 245.3, 5));
        mangas.add(new Manga(7L, "Magin Bu", 622, 0));
        mangas.add(new Manga(4L, "Attack on TI",667.32, 6));
        mangas.add(new Manga(4L, "Attack on TI",667.32, 6)); //Note esse manga duplicado. O set se encarrega de checar pelo método equals (de novo a importancia
        //de ter um equals bem definido) se esse mangá já existe. E como é uma coleção de elementos únicos pelo hash, nao é permitido elementos duplicados.

        for(Manga manga : mangas){
            System.out.println(manga); //Se quiser que apareça na ordem de inserção, usa um LinkedHashSet
        }
    }
}
