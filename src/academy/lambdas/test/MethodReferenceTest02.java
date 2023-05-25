package academy.lambdas.test;

import academy.lambdas.dominio.Anime;
import academy.lambdas.service.AnimeComparators;

import java.util.ArrayList;
import java.util.List;

//Reference to an instance method of a particular object
public class MethodReferenceTest02 {
    public static void main(String[] args) { //chamando através de um objeto
        List<Anime> animeList = new ArrayList<>(List.of(new Anime("ZZTTop", 1124), new Anime("Attack on title", 55), new Anime("Jojojojo", 210), new Anime("OnPiz", 456)));
        AnimeComparators animeComparators = new AnimeComparators();
        animeList.sort(animeComparators::compareByEpisodesNonStatic);
        System.out.println(animeList);
    }
}
