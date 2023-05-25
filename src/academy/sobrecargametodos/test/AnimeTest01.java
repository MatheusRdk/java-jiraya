package academy.sobrecargametodos.test;

import academy.sobrecargametodos.dominio.Animes;

public class AnimeTest01 {
    public static void main(String[] args) {
        Animes anime = new Animes();
        //anime.setTipo("TV");
        //anime.setEpisodios(48);    
        anime.init("ONpici", "TV", 1500, "naobinerie");

        anime.imprime();
    }   
}
