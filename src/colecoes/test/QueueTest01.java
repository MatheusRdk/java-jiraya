package colecoes.test;

import colecoes.dominio.Consumidor;
import colecoes.dominio.Manga;

import java.util.PriorityQueue;
import java.util.Queue;

public class QueueTest01 {
    public static void main(String[] args) {
        Queue<String> fila = new PriorityQueue<>();
        fila.add("D");
        fila.add("A");
        fila.add("B");
        while (!fila.isEmpty()){
            System.out.println(fila.poll()); //Retorna e remove o primeiro da fila
            //System.out.println(fila.peek()); //Retorna o primeiro da fila
        }
        System.out.println("------------------------------------------------------");
        Consumidor consumidor = new Consumidor("Mathweue");
        Queue<Consumidor> fila2 = new PriorityQueue<>();
        //fila2.add(consumidor); //Esse da erro, pois para queue os objetos também precisam ser comparáveis, e consumidor nao tem o comparable.

        System.out.println("------------------------------------------------------");
        Queue<Manga> mangas = new PriorityQueue<>(new MangaPrecoComparator().reversed()); //O reversed vai inverter a ordem, nesse caso do maior pro menor, ai será removido o maior
        mangas.add(new Manga(5L, "Vc conhece PICOLO?", 668.2));
        mangas.add(new Manga(1L, "Narruto", 245.3));
        mangas.add(new Manga(2L, "Dragon Ball", 367));
        mangas.add(new Manga(7L, "Magin Bu", 622));
        mangas.add(new Manga(4L, "Attack on TI",667.32));
        while (!mangas.isEmpty()) {
            System.out.println(mangas.poll()); //Veja que o maior aparece primeiro e ele que será removido.
        }
    }
}
