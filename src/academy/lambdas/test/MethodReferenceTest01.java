package academy.lambdas.test;

import academy.lambdas.dominio.Anime;
import academy.lambdas.service.AnimeComparators;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

//Reference to a static method.
public class MethodReferenceTest01 {    //La no AnimeComparators, vc cria quantos comparadores quiser e usa como parametro no sort com uma lambda, usando a sintaxe do methodreference.
    public static void main(String[] args) {
        List<Anime> animeList = new ArrayList<>(List.of(new Anime("ZZTTop", 1124), new Anime("Attack on title", 55), new Anime("Jojojojo", 210), new Anime("OnPiz", 456)));
 //       Collections.sort(animeList, (o1, o2) -> o1.getTitle().compareTo(o2.getTitle())); Ao inves disso, vc cria os comparadores em outra classe e usa com methodreference.
 //       Collections.sort(animeList, AnimeComparators::compareByTitle);
        Collections.sort(animeList, AnimeComparators::compareByEpisodes);
        System.out.println(animeList);
    }
}
