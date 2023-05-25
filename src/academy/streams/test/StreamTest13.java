package academy.streams.test;

import academy.streams.dominio.Category;
import academy.streams.dominio.LightNovel;
import academy.streams.dominio.Promotion;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class StreamTest13 {
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
        Map<Promotion, List<LightNovel>> promotionListMap = lightNovels.stream().collect(Collectors.groupingBy(ln -> ln.getPrice() < 6 ? Promotion.UNDER_PROMOTION : Promotion.NORMAL_PRICE));
        System.out.println(promotionListMap);  //Vc pode colocar dentro do groupingBy uma logica com lambda e ainda um operador ternario.
        System.out.println("-----------------------");

        //Map<Category, Map<Promotion, List<LightNovel>>>
        Map<Category, Map<Promotion, List<LightNovel>>> categoryMapMap = lightNovels.stream().collect(Collectors.groupingBy(LightNovel::getCategory,
                Collectors.groupingBy(ln -> ln.getPrice() < 6 ? Promotion.UNDER_PROMOTION : Promotion.NORMAL_PRICE))); //Perceba que quando gerada a variavel local referencia criou
                                                                                                                      //exatamente o que queriamos.
                                                                            //Nao e um codigo muito facil de entender, com banco de dados e bem mais facil.
        System.out.println(categoryMapMap);
    }
}
