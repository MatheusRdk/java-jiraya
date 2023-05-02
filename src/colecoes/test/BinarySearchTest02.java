package colecoes.test;

import colecoes.dominio.Manga;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BinarySearchTest02 {
    public static void main(String[] args) {
        List<Manga> mangas = new ArrayList<>(6);
        mangas.add(new Manga(5L, "Vc conhece PICOLO?", 668.2));
        mangas.add(new Manga(1L, "Narruto", 245.3));
        mangas.add(new Manga(2L, "Dragon Ball", 367));
        mangas.add(new Manga(7L, "Magin Bu", 622));
        mangas.add(new Manga(4L, "Attack on TI",667.32));
        //Collections.sort(mangas);
        mangas.sort(new MangaByIdComparator());
        for (Manga manga : mangas){
            System.out.println(manga);
        }

        Manga mangaToSearch = new Manga(4L, "Attack on TI",667.32);                //Estamos sortando por ID, importante saber pelo que está sendo feito o sort.
        System.out.println(Collections.binarySearch(mangas, mangaToSearch, new MangaByIdComparator())); //Vc deve passar também o comparator dentro dele aqui
    }
}
