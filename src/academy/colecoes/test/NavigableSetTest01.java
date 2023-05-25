package academy.colecoes.test;

import academy.colecoes.dominio.Manga;
import academy.colecoes.dominio.Smartphone;

import java.util.Comparator;
import java.util.NavigableSet;
import java.util.TreeSet;


class SmartphoneMarcaComparator implements Comparator<Smartphone>{
    @Override
    public int compare(Smartphone o1, Smartphone o2) {
        return o1.getMarca().compareTo(o2.getMarca());
    }
}

class MangaPrecoComparator implements Comparator<Manga>{
    @Override
    public int compare(Manga o1, Manga o2) {
        return Double.compare(o1.getPreco(), o2.getPreco());
    }
}
public class NavigableSetTest01 {
    public static void main(String[] args) {
        NavigableSet<Smartphone> set = new TreeSet<>(new SmartphoneMarcaComparator()); //Quando trabalha com algo escrito Tree, geralmente vai precisar que a classe seja Comparable
        Smartphone smartphone = new Smartphone("2F2DS", "SAMSUNG"); //para poder ser sortada. Portanto, ou sua classe implementa Comparable, ou vc cria uma classe
        set.add(smartphone);                                                         //Comparator e passa no new TreeSet<>(aqui). Se nao fizer isso da ClassCastException
        System.out.println(set);                                                    //O TreeSet também não aceita elementos duplicados (isso vai do equals ou do compareTo/compare).
        System.out.println("---------------------");

        NavigableSet<Manga> mangas = new TreeSet<>(new MangaPrecoComparator()); //Manga implementa Comparable
        mangas.add(new Manga(5L, "Vc conhece PICOLO?", 668.2));
        mangas.add(new Manga(1L, "Narruto", 245.3));
        mangas.add(new Manga(2L, "Dragon Ball", 367));
        mangas.add(new Manga(7L, "Magin Bu", 622));
        mangas.add(new Manga(4L, "Attack on TI",667.32));
        for (Manga manga : mangas) {
            System.out.println(manga);
        }
        System.out.println("-----------------------");

        Manga yuyu = new Manga(6L, "Yuyu Hakuyu", 610); //Como agora mangas estão ordenados pelo preço, existem alguns métodos para serem utilizados

        System.out.println("Lower: " + mangas.lower(yuyu)); //Lower trás o valor imediatamente menor que o que vc passou.
        System.out.println("Floor: " + mangas.floor(yuyu)); //Floor trás o valor igual ou menor que o que vc passou.
        System.out.println("Higher: " + mangas.higher(yuyu)); //Higher trás o valor imediatamente maior que o que vc passou.
        System.out.println("Ceiling: " + mangas.ceiling(yuyu)); //Ceiling trás o valor igual ou maior que o que vc passou.

        System.out.println(mangas.size());
        System.out.println(mangas.pollFirst()); //Deleta o primeiro elemento da lista
        System.out.println(mangas.pollLast()); //Deleta o último elemento da lista
        System.out.println(mangas.size()); //Perceba que o size diminui em 2


    }  //O treeSet vai mostrar conforme o compareTo da classe ou pelo Comparator que vc criar. Isso faz ela ter uma performance boa, mas nao a melhor, O(log n)
}
