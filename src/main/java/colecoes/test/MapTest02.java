package colecoes.test;

import colecoes.dominio.Consumidor;
import colecoes.dominio.Manga;

import java.util.HashMap;
import java.util.Map;

public class MapTest02 {
    public static void main(String[] args) { //Quero associar um consumidor e o mangá que ele comprou.
        Consumidor consumidor1 = new Consumidor("Matheus");
        Consumidor consumidor2 = new Consumidor("Empresa do Brasil");

        Manga manga1 = new Manga(5L, "Vc conhece PICOLO?", 668.2);
        Manga manga2 = new Manga(1L, "Narruto", 245.3);
        Manga manga3 = new Manga(2L, "Dragon Ball", 367);
        Manga manga4 = new Manga(7L, "Magin Bu", 622);
        Manga manga5 = new Manga(4L, "Attack on TI",667.32);

        Map<Consumidor, Manga> consumidorManga = new HashMap<>();
        consumidorManga.put(consumidor1, manga1);
        consumidorManga.put(consumidor2, manga4);
        for(Map.Entry<Consumidor, Manga> entry : consumidorManga.entrySet()){
            System.out.println("Consumidor: " + entry.getKey().getNome() + " - Manga comprado: " + entry.getValue().getNome());
        }
    }
}
