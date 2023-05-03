package colecoes.test;

import colecoes.dominio.Manga;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class IteratorTest01 {
    public static void main(String[] args) {
        List<Manga> mangas = new ArrayList<>(6);
        mangas.add(new Manga(5L, "Vc conhece PICOLO?", 668.2, 0));
        mangas.add(new Manga(1L, "Narruto", 245.3, 5));
        mangas.add(new Manga(7L, "Magin Bu", 622, 0));
        mangas.add(new Manga(4L, "Attack on TI",667.32, 6));

        //Digamos que vc quer deletar os mangas de quantidade 0. A melhor forma de fazer isso é através do Iterator.

        Iterator<Manga> mangaIterator = mangas.iterator();
        while(mangaIterator.hasNext()){   //Verifica se tem o próximo. Isso deixa mais seguro o remove.
            //Manga next = mangaIterator.next(); //Associa esse próximo a uma variável local. Ou faz em uma linha só igual embaixo.
            if(mangaIterator.next().getQuantidade() == 0){    //Ai faz o if pro atributo que vc quer
                mangaIterator.remove();  //Usa mangaIterator.remove, pq é o mangaIterator que está gerenciando o arrayList nesse momento. Mas quem perderá o manga vai se o "mangas".
            }
        }
        System.out.println(mangas);  //Esse modo acima é o modo antigo. O próximo veio com programção funcional e é mais moderno.
        System.out.println("--------------------------------");

        //Esse manga dentro dos parenteses é um nome dado pros valores dentro de mangas, igual vc faz no loop Mangas manga : mangas.
        mangas.removeIf(manga -> manga.getQuantidade() == 0);
        System.out.println(mangas);   //Dessa forma o resultado é o mesmo, e se vc verificar o removeIf vai perceber que ele usa o mesmo método do iterator usado acima.

    }
}
