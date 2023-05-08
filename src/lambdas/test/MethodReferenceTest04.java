package lambdas.test;

import lambdas.dominio.Anime;
import lambdas.service.AnimeComparators;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Supplier;

//Reference to a constructor
public class MethodReferenceTest04 {
    public static void main(String[] args) {
        Supplier<AnimeComparators> newAnimeComparator = AnimeComparators::new;
        AnimeComparators animeComparators = newAnimeComparator.get();

        List<Anime> animeList = new ArrayList<>(List.of(new Anime("ZZTTop", 1124), new Anime("Attack on title", 55), new Anime("Jojojojo", 210), new Anime("OnPiz", 456)));
        animeList.sort(animeComparators::compareByEpisodesNonStatic);
        System.out.println(animeList);

        //BiFunction vai receber 3 argumentos, T, U e retorna R. Ai vc consegue usar um construtor.
        BiFunction<String, Integer, Anime> animeBiFunction = (title, episodes) -> new Anime(title, episodes);
        BiFunction<String, Integer, Anime> animeBiFunction2 = Anime::new; //MethodReference
        System.out.println(animeBiFunction2.apply("SuperAnime", 192)); //É o apply que se encarrega de criar o anime.
    }
}
