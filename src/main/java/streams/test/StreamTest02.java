package streams.test;

import streams.dominio.LightNovel;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

//1. Order LightNovel by title
//2. Retrieve the first 3 titles light novels with price less than 4.
public class StreamTest02 { //Esse é o jeito com streams.
    public static List<LightNovel> lightNovels = new ArrayList<>(List.of(new LightNovel("Memes", 7), new LightNovel("OuterMEmes", 5), new LightNovel("Memeiro2", 1.99),
            new LightNovel("Outerumums", 2.50), new LightNovel("OuterWARUDO", 2.68), new LightNovel("SUS", 5.99), new LightNovel("HASHIBAINU", 1)));

    public static void main(String[] args) {
        List<String> titles = lightNovels.stream() //o lightnovels tem o elemento stream, significa que agora vamos ter acesso a uma "sequencia" de lightnovels.
                //Stream trabalha em "corrente", vc vai adicionando métodos que retornam outra stream.
                .sorted(Comparator.comparing(LightNovel::getTitle))
                .filter(ln -> ln.getPrice() <= 4)
                .limit(3)
                .map(LightNovel::getTitle) //o map recebe uma funçao, lembre que funçao recebe um T e retorna R.
                .collect(Collectors.toList());

        System.out.println(titles); //Tudo foi feito da mesma forma mas bem mais fácil.
    }
}
