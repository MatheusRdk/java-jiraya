package academy.streams.test;

import academy.streams.dominio.Category;
import academy.streams.dominio.LightNovel;
import academy.streams.dominio.Promotion;

import java.util.*;
import java.util.stream.Collectors;

public class StreamTest15 {
    public static List<LightNovel> lightNovels = new ArrayList<>(List.of(
            new LightNovel("Memes", 7, Category.DRAMA),
            new LightNovel("OuterMEmes", 5, Category.FANTASY),
            new LightNovel("Memeiro2", 1.99, Category.DRAMA),
            new LightNovel("Outerumums", 2.50, Category.DRAMA),
            new LightNovel("OuterWARUDO", 6.50, Category.FANTASY),
            new LightNovel("SUS", 5.99, Category.FANTASY),
            new LightNovel("HASHIBAINU", 1, Category.ROMANCE),
            new LightNovel("HASHIBAINU", 1, Category.ROMANCE)));


    public static void main(String[] args) { //Agora queremos o summarizing por categoria
        Map<Category, DoubleSummaryStatistics> collect = lightNovels.stream().collect(Collectors.groupingBy(LightNovel::getCategory, Collectors.summarizingDouble(LightNovel::getPrice)));
        System.out.println(collect);
        System.out.println("-------------------");

        //Agora queremos se dentro do category temos algo em promoção
        Map<Category, Set<Promotion>> categoryListMap = lightNovels.stream().collect(Collectors.groupingBy(LightNovel::getCategory, Collectors.mapping(StreamTest15::getPromotion, Collectors.toSet())));
        System.out.println(categoryListMap);

        //Agora com LinkedHashSet (somente muda a sequencia que aparece)
        Map<Category, LinkedHashSet<Promotion>> collect1 = lightNovels.stream().collect(Collectors.groupingBy(LightNovel::getCategory, Collectors.mapping(StreamTest15::getPromotion, Collectors.toCollection(LinkedHashSet::new))));
        System.out.println(collect1);
    }
    public static Promotion getPromotion(LightNovel ln){ //Metodo que deixou a classificacao de promocao mais curta pra usar.
        return ln.getPrice() < 6 ? Promotion.UNDER_PROMOTION : Promotion.NORMAL_PRICE;
    }
}
