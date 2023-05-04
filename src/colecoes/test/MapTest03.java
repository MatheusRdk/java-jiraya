package colecoes.test;

import colecoes.dominio.Consumidor;
import colecoes.dominio.Manga;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MapTest03 {
    public static void main(String[] args) { //Quero associar um consumidor e o mangá que ele comprou.
        Consumidor consumidor1 = new Consumidor("Matheus");
        Consumidor consumidor2 = new Consumidor("Empresa do Brasil");

        Manga manga1 = new Manga(5L, "Vc conhece PICOLO?", 668.2);
        Manga manga2 = new Manga(1L, "Narruto", 245.3);
        Manga manga3 = new Manga(2L, "Dragon Ball", 367);
        Manga manga4 = new Manga(7L, "Magin Bu", 622);
        Manga manga5 = new Manga(4L, "Attack on TI",667.32);

        Map<Consumidor, List<Manga>> consumidorManga = new HashMap<>();  //Para associar vários mangas, faz uma lista
        List<Manga> mangasConsumidor1List = List.of(manga1, manga3, manga5);
        List<Manga> mangasConsumidor2List = List.of(manga2, manga4, manga1);
        consumidorManga.put(consumidor1, mangasConsumidor1List);
        consumidorManga.put(consumidor2, mangasConsumidor2List);
        for (Map.Entry<Consumidor, List<Manga>> entry : consumidorManga.entrySet()) {
            System.out.println("Nome: " + entry.getKey().getNome());
            System.out.println("Mangas comprados:");
            for (Manga manga : entry.getValue()){   //Para printar cada nome, já que é uma lista vc faz mais um loop.
                System.out.print(manga.getNome() + " ");
            }
            System.out.println();
        }

    }
}
