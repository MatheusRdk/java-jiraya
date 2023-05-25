package academy.streams.test;

import academy.streams.dominio.Category;
import academy.streams.dominio.LightNovel;

import java.util.*;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.stream.Collectors;

public class StreamTest14 {
    public static List<LightNovel> lightNovels = new ArrayList<>(List.of(
            new LightNovel("Memes", 7, Category.DRAMA),
            new LightNovel("OuterMEmes", 5, Category.FANTASY),
            new LightNovel("Memeiro2", 1.99, Category.DRAMA),
            new LightNovel("Outerumums", 2.50, Category.DRAMA),
            new LightNovel("OuterWARUDO", 6.50, Category.FANTASY),
            new LightNovel("SUS", 5.99, Category.FANTASY),
            new LightNovel("HASHIBAINU", 1, Category.ROMANCE),
            new LightNovel("HASHIBAINU", 1, Category.ROMANCE)));


    public static void main(String[] args) {
        Map<Category, Long> categoryLongMap = lightNovels.stream().collect(Collectors.groupingBy(LightNovel::getCategory, Collectors.counting())); //Contando por categoria.
        //Perceba que vc pode colocar dentro do groupingBy uma especie de "chave-valor", que podem ser outros metodos do Collectors.
        System.out.println(categoryLongMap);
        System.out.println("------------------------------");

        //Organizando por maior preço por categoria.

        Map<Category, Optional<LightNovel>> categoryOptionalMap = lightNovels.stream().collect(Collectors.groupingBy(LightNovel::getCategory, Collectors.maxBy(Comparator.comparing(LightNovel::getPrice))));
        System.out.println(categoryOptionalMap);
        //Precisamos remover esse optional.
        System.out.println("------------------------------");

        //Duas formas de fazer, a primeira e a recomendada pelo IntelliJ depois que fiz a segunda.
        Map<Category, LightNovel> collected = lightNovels.stream().collect(Collectors.toMap(LightNovel::getCategory, Function.identity(), BinaryOperator.maxBy(Comparator.comparing(LightNovel::getPrice))));
        System.out.println(collected);

        Map<Category, LightNovel> collected2 = lightNovels.stream().collect(Collectors.groupingBy(LightNovel::getCategory, Collectors.collectingAndThen(Collectors.maxBy(Comparator.comparing(LightNovel::getPrice)), Optional::get)));
        System.out.println(collected2);
    }
}
