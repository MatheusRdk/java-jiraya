package academy.streams.test;

import academy.streams.dominio.LightNovel;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.DoubleSummaryStatistics;
import java.util.List;
import java.util.stream.Collectors;

public class StreamTest11 {//Collectors
    public static List<LightNovel> lightNovels = new ArrayList<>(List.of(new LightNovel("Memes", 7), new LightNovel("OuterMEmes", 5), new LightNovel("Memeiro2", 1.99),
            new LightNovel("Outerumums", 2.50), new LightNovel("OuterWARUDO", 2.68), new LightNovel("SUS", 5.99),
            new LightNovel("HASHIBAINU", 1), new LightNovel("HASHIBAINU", 1)));


    public static void main(String[] args) {
        System.out.println(lightNovels.stream().count()); //Stream
        System.out.println(lightNovels.stream().collect(Collectors.counting())); //Collect

        lightNovels.stream().max(Comparator.comparing(LightNovel::getPrice)).ifPresent(System.out::println); //Max com stream
        lightNovels.stream().collect(Collectors.maxBy(Comparator.comparing(LightNovel::getPrice))).ifPresent(System.out::println); //Usando collect. Min é igual

        System.out.println(lightNovels.stream().mapToDouble(LightNovel::getPrice).sum()); //Somando com stream
        System.out.println(lightNovels.stream().collect(Collectors.summingDouble(LightNovel::getPrice))); //Com collect. Diferente dos outros, vc faz dentro de um sout pq ele retorna double

        lightNovels.stream().mapToDouble(LightNovel::getPrice).average().ifPresent(System.out::println);
        System.out.println(lightNovels.stream().collect(Collectors.averagingDouble(LightNovel::getPrice)));

        //Fora as operaçoes basicas, o collect tem coisas interessantes.

        DoubleSummaryStatistics summaryStatistics = lightNovels.stream().collect(Collectors.summarizingDouble(LightNovel::getPrice));
        System.out.println(summaryStatistics); //Ele tras um resumo de todas aquelas operacoes com um codigo somente.

        String collect = lightNovels.stream().map(LightNovel::getTitle).collect(Collectors.joining(", "));
        System.out.println(collect); //Esse pegou todos os titulos e separou por virgula, um jeito bem facil de mostrar alguma string.
        //O bom é que o ultimo elemento nao tem a virgula depois.
    }
}
