package academy.streams.test;

import academy.streams.dominio.LightNovel;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

//1. Order LightNovel by title
//2. Retrieve the first 3 titles light novels with price less than 4.
public class StreamTest01 { //Esse seria o jeito antigo de fazer isso.
    public static List<LightNovel> lightNovels = new ArrayList<>(List.of(new LightNovel("Memes", 7), new LightNovel("OuterMEmes", 5), new LightNovel("Memeiro2", 1.99),
            new LightNovel("Outerumums", 2.50), new LightNovel("OuterWARUDO", 2.68), new LightNovel("SUS", 5.99), new LightNovel("HASHIBAINU", 1)));

    public static void main(String[] args) {
        lightNovels.sort(Comparator.comparing(LightNovel::getTitle));
        System.out.println(lightNovels);
        List<String> titles = new ArrayList<>();
        for (LightNovel lightNovel : lightNovels) {
            if (lightNovel.getPrice() <= 4){
                titles.add(lightNovel.getTitle());
            }
            if (titles.size() >= 3) {
                break;
            }
        }
        System.out.println(titles);
    }
}
