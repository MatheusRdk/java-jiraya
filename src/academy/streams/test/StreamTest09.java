package academy.streams.test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamTest09 {
    public static void main(String[] args) {
        IntStream.range(1, 50).filter(num -> num % 2 == 0).forEach(n -> System.out.print(n + " "));
        System.out.println(); //O range nao inclui o ultimo numero, e o closed inclui.
        IntStream.rangeClosed(1, 50).filter(num -> num % 2 == 0).forEach(n -> System.out.print(n + " "));
        System.out.println();

        Stream.of("Memes", "Sao mto", "looooooooooooooooo", "cos")//Assim vc cria uma stream do que vier nos argumetos.
                .map(String::toUpperCase)
                .forEach(s -> System.out.print(s + " "));
        System.out.println();

        int[] num = {1, 2, 3, 4, 5, 6}; //O array.stream(num) retorna um intStream, o que nos permite ja encadear métodos de números.
        Arrays.stream(num)
                .average()
                .ifPresent(System.out::println);

        System.out.println("-------------------");
        try(Stream<String> lines = Files.lines(Paths.get("file.txt"))){
            lines.filter(l -> l.contains("Java"))
                    .forEach(System.out::println);
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}