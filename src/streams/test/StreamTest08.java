package streams.test;

import streams.dominio.LightNovel;

import java.util.ArrayList;
import java.util.List;

public class StreamTest08 {
    public static List<LightNovel> lightNovels = new ArrayList<>(List.of(new LightNovel("Memes", 7), new LightNovel("OuterMEmes", 5), new LightNovel("Memeiro2", 1.99),
            new LightNovel("Outerumums", 2.50), new LightNovel("OuterWARUDO", 2.68), new LightNovel("SUS", 5.99),
            new LightNovel("HASHIBAINU", 1), new LightNovel("HASHIBAINU", 1)));

    public static void main(String[] args) {//Reduce
        lightNovels.stream()
                .map(LightNovel::getPrice)
                .filter(price -> price > 5)
                .reduce(Double::sum) //Perceba que o java sozinho faz o boxing e o unboxing pra trabalhar com primitivos e wrappers.
                .ifPresent(System.out::println);

        double sum = lightNovels.stream()
                .mapToDouble(LightNovel::getPrice)//Com esse mapToDouble, vc fala pro java nao ficar mudando wrapper e primitivo, e ele retorna um DoubleStream
                .filter(price -> price > 5)
                .sum(); //Do doubleStream vc tem acesso a métodos de números, como no caso desse sum que vai retornar um tipo primitivo.
        System.out.println(sum);
    }
}
