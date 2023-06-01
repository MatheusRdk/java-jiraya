package academy.crud.service;

import academy.crud.dominio.Anime;
import academy.crud.dominio.Producer;
import academy.crud.repository.AnimeRepository;

import java.util.Optional;
import java.util.Scanner;

public class AnimeService {
    private static final Scanner SCANNER = new Scanner(System.in);

    public static void menu(int op) {
        switch (op) { //Sintaxe do enhanced switch
            case 1 -> findByName();
            case 2 -> delete();
            case 3 -> save();
            case 4 -> update();
        }
    }

    private static void findByName() {
        System.out.println("Type a name or empty to all");
        String name = SCANNER.nextLine(); //A entrada de dados faz parte do método.
        AnimeRepository.findByName(name)
                .forEach(a -> System.out.printf("ID: %d - %s - Ep: %d - Prod.: %s%n", a.getId(), a.getName(), a.getEpisodes(), a.getProducer().getName()));
    }

    private static void delete() {
        System.out.println("Type one of the ids below to delete");
        int id = Integer.parseInt(SCANNER.nextLine());
        System.out.println("Are you sure? Y/N");
        String choice = SCANNER.nextLine();
        if ("y".equalsIgnoreCase(choice)) {
            AnimeRepository.delete(id);
        }
    }

    private static void save() {
        System.out.println("Type the name of the anime");
        String name = SCANNER.nextLine();
        System.out.println("Type the number of episodes");
        int episodes = Integer.parseInt(SCANNER.nextLine());
        System.out.println("Type the id of the producer");
        Integer producerId = Integer.parseInt(SCANNER.nextLine());
        Anime anime = Anime.builder()
                .name(name)
                .episodes(episodes)
                .producer(Producer.builder().id(producerId).build())
                .build();
        AnimeRepository.save(anime);
    }

    private static void update() {
        System.out.println("Type the id of the object you want to update");
        Optional<Anime> optionalAnime = AnimeRepository.findById(Integer.parseInt(SCANNER.nextLine()));
        if (optionalAnime.isEmpty()) {
            System.out.println("Anime not found");
            return;
        }
        Anime animeFromDB = optionalAnime.get();
        System.out.println("Anime found: " + animeFromDB);
        System.out.println("Type the new name or enter to keep the same");
        String name = SCANNER.nextLine();
        name = name.isEmpty() ? animeFromDB.getName() : name;

        System.out.println("Type the new number of episodes");
        int episodes = Integer.parseInt(SCANNER.nextLine());

        Anime animeToUpdate = Anime.builder()//Como vc trabalha com objeto (anime) imutável, vc precisa criar outro objeto pra dar update, com o mesmo id e o nome setado em cima
                .id(animeFromDB.getId())
                .episodes(episodes)
                .producer(animeFromDB.getProducer())
                .name(name)
                .build();
        AnimeRepository.update(animeToUpdate);
    }
}
