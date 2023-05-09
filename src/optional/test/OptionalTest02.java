package optional.test;

import optional.domain.Manga;
import optional.repository.MangaRepository;

import java.util.Optional;

public class OptionalTest02 {
    public static void main(String[] args) {
        Optional<Manga> byTitle = MangaRepository.findByTitle("Midoriya");
        byTitle.ifPresent(manga -> manga.setTitle("Midoryia!!!!!!!!!!!!!!!!!!!!!!!!!!!!!")); //Se ele achar faz essa alteração.
        System.out.println(byTitle);
        MangaRepository.findById(2).orElseThrow(IllegalArgumentException::new); //Aqui ele com orElseThrow vc escolhe jogar uma exceção caso nao ache.
        Manga createNew = MangaRepository.findByTitle("DragonBolll").orElse(new Manga(3, "DragonBolll", 2220));
        System.out.println(createNew); //Nesse vc criou caso nao exista.
    }
}
