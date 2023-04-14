package modificadorestatico.test;

import modificadorestatico.dominio.Anime;

public class AnimeTest01 {
    public static void main(String[] args) {
        Anime anime1 = new Anime("MEmes");
        Anime anime2 = new Anime("Memergency");
        Anime anime3 = new Anime("MEMenie");

        Anime.getEpisodios();
        anime1.getNome();
        anime2.getNome();
        anime3.getNome();
    }
}
