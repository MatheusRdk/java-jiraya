package academy.lambdas.test;

import java.util.List;
import java.util.function.Consumer;

public class LambdaTest01 {
    public static void main(String[] args) {  //O consumer vai trabalhar igual o Predicate, porem retorna void.
        List<String> strings = List.of("Matheus", "Mathhhh", "GOKU", "MAJINBU");
        forEach(strings, s -> System.out.println(s));
    }
    private static <T> void forEach (List<T> list, Consumer<T> consumer){
        for (T e : list){
            consumer.accept(e);
        }
    }
}
