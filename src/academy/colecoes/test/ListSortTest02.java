package academy.colecoes.test;

import academy.colecoes.dominio.Manga;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

class MangaByIdComparator implements Comparator<Manga>{
    @Override
    public int compare(Manga manga1, Manga manga2) { //Exatamente as mesmas regras do compareTo. Vc criou aqui um método de fazer o sort por id
        return manga1.getId().compareTo(manga2.getId());
    }
}


public class ListSortTest02 {

    public static void main(String[] args) {
        List<Manga> mangas = new ArrayList<>(6);
        mangas.add(new Manga(5L, "Vc conhece PICOLO?", 668.2));
        mangas.add(new Manga(1L, "Narruto", 245.3));    //Agora pense se vc precisa que em um certo ponto do programa o sort seja com base em um atributo, mas a partir de
        mangas.add(new Manga(2L, "Dragon Ball", 367)); // outro ponto ele tem que ser com base em outro atributo. Ai vc trabalha com a classe Comparator
        mangas.add(new Manga(7L, "Magin Bu", 622));
        mangas.add(new Manga(4L, "Attack on TI",667.32));

        for (Manga manga : mangas){
            System.out.println(manga);
        }
        System.out.println("---------------------------------------------");
        Collections.sort(mangas);
        for (Manga manga : mangas){
            System.out.println(manga);
        }

        System.out.println("---------------------------------------------");
        //Collections.sort(mangas, new MangaByIdComparator()); Vc pode escrever assim, já que o collections tem o método sobrecarregado.
        mangas.sort(new MangaByIdComparator()); //Mas assim é preferível por ser menor.
        for (Manga manga : mangas){ //Portanto, vc cria aquela classe, sobreescreve o método do Comparator (compare) e coloca a lógica de sort ali. Ai pra usar é assim.
            System.out.println(manga);
        }
    }
}
