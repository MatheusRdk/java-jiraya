package academy.streams.test;

import academy.streams.dominio.LightNovel;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class StreamTest06 {
    public static List<LightNovel> lightNovels = new ArrayList<>(List.of(new LightNovel("Memes", 7), new LightNovel("OuterMEmes", 5), new LightNovel("Memeiro2", 1.99),
            new LightNovel("Outerumums", 2.50), new LightNovel("OuterWARUDO", 2.68), new LightNovel("SUS", 5.99),
            new LightNovel("HASHIBAINU", 1), new LightNovel("HASHIBAINU", 1)));


    public static void main(String[] args) {
        System.out.println(lightNovels.stream().anyMatch(ln -> ln.getPrice() <= 2)); //Retornam boolean.
        System.out.println(lightNovels.stream().allMatch(ln -> ln.getPrice() >= 0));
        System.out.println(lightNovels.stream().noneMatch(ln -> ln.getPrice() >= 0));

        System.out.println("---------------");

        lightNovels.stream() //Printa se tiver algum ln com preço maior que 5
                .filter(ln -> ln.getPrice() > 5)
                .findAny()//Retorna um optional, precisa resolver com um método do optional, igual o de baixo.
                .ifPresent(System.out::println);

        lightNovels.stream()
                .filter(ln -> ln.getPrice() > 3)
                .sorted(Comparator.comparing(LightNovel::getPrice))
                .findFirst() //Vai pegar o primeiro da lista SORTADA que tem preço maior que 3.
                .ifPresent(System.out::println);
    }
}
