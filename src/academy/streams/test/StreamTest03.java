package academy.streams.test;

import academy.streams.dominio.LightNovel;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class StreamTest03 { //Outros métodos da stream
    public static List<LightNovel> lightNovels = new ArrayList<>(List.of(new LightNovel("Memes", 7), new LightNovel("OuterMEmes", 5), new LightNovel("Memeiro2", 1.99),
            new LightNovel("Outerumums", 2.50), new LightNovel("OuterWARUDO", 2.68), new LightNovel("SUS", 5.99),
            new LightNovel("HASHIBAINU", 1), new LightNovel("HASHIBAINU", 1)));

    public static void main(String[] args) {
        Stream<LightNovel> novelStream = lightNovels.stream();//Veja que stream nao e uma operacao final, pq retorna outra stream.
        lightNovels.forEach(System.out::println);
        long count = novelStream.filter(ln -> ln.getPrice() <= 4).count();
        System.out.println(count);
        System.out.println("--------------------------------------------");
        long countDistinct = lightNovels.stream() //Para funcionar, vc precisa abrir a stream de novo.
                .distinct() //Para dar certo o distinct vc precisa definir o equals e hashcode.
                .filter(ln -> ln.getPrice() <= 4)
                .count();
        System.out.println(countDistinct);
    }
}
