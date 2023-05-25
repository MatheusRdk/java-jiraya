package academy.streams.test;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamTest05 { //FlatMap

    public static void main(String[] args) {
        List<String> words = List.of("Me", "que", "tre", "fe");
        String[] letters = words.get(0).split(""); //Jeito antigo de fazer
        System.out.println(Arrays.toString(letters));
        Stream<String> letterString = Arrays.stream(letters); //Transformando um array para stream.

        List<String[]> collected = words.stream().map(l -> l.split("")).collect(Collectors.toList()); //essa stream retornou uma lista de array de strings.
        System.out.println(collected); //Assim ele so retornou os espaços em memoria de cada array
        System.out.println("-----------------------------");
        List<String> letters2 = words.stream().map(l -> l.split("")).flatMap(Arrays::stream).collect(Collectors.toList());
        System.out.println(letters2); //Assim o flatmap foi mais afundo e pegou tudo, uma stream saiu da referencia e ja fez seu papel com o flatmap
    }
}
