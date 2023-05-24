package streams.test;

import streams.dominio.Category;
import streams.dominio.LightNovel;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class StreamTest12 {
    public static List<LightNovel> lightNovels = new ArrayList<>(List.of(new LightNovel("Memes", 7, Category.DRAMA),
            new LightNovel("OuterMEmes", 5, Category.FANTASY),
            new LightNovel("Memeiro2", 1.99, Category.DRAMA),
            new LightNovel("Outerumums", 2.50, Category.DRAMA),
            new LightNovel("OuterWARUDO", 2.68, Category.FANTASY),
            new LightNovel("SUS", 5.99, Category.FANTASY),
            new LightNovel("HASHIBAINU", 1, Category.ROMANCE),
            new LightNovel("HASHIBAINU", 1, Category.ROMANCE)));


    public static void main(String[] args) {
        Map<Category, List<LightNovel>> categoryLightNovelMap = new HashMap<>();
        List<LightNovel> fantasy = new ArrayList<>();
        List<LightNovel> drama = new ArrayList<>();
        List<LightNovel> romance = new ArrayList<>();
        for (LightNovel lightNovel : lightNovels){
            switch (lightNovel.getCategory()){
                case DRAMA : drama.add(lightNovel); break;
                case FANTASY: fantasy.add(lightNovel); break;
                case ROMANCE: romance.add(lightNovel); break;
            }
        }
        categoryLightNovelMap.put(Category.DRAMA, drama);
        categoryLightNovelMap.put(Category.FANTASY, fantasy);
        categoryLightNovelMap.put(Category.ROMANCE, romance);
        System.out.println(categoryLightNovelMap);

        Map<Category, List<LightNovel>> collected = lightNovels.stream().collect(Collectors.groupingBy(LightNovel::getCategory)); //Perceba que a var referencia gerada foi igual a que
        //fizemos ali em cima.
        System.out.println(collected); //Com uma linha fizemos tudo aquilo em cima, alem dele aceitar as modificaçoes futuras sem precisar alterar o codigo e criar listas manualmentes
    }
}
