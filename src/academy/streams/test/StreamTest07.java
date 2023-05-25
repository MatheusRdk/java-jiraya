package academy.streams.test;

import java.util.List;

public class StreamTest07 {

    public static void main(String[] args) {//Reduce
        List<Integer> integers = List.of(1, 3, 5, 7, 99, 24);

        integers.stream().reduce((x, y) -> x+y).ifPresent(System.out::println);
        integers.stream().reduce(Integer::sum).ifPresent(System.out::println);

        System.out.println(integers.stream().reduce(0, (x,y) -> x+y)); //Faz a mesma coisa, mas colocou o valor inicial 0, e nao retorna um Optional.
        System.out.println(integers.stream().reduce(0, Integer::sum));

        System.out.println("--------------------------------------------------"); //Multiplicaçao
        integers.stream().reduce((x, y) -> x*y).ifPresent(System.out::println);
        System.out.println(integers.stream().reduce(1, (x, y) -> x*y));

        System.out.println("--------------------------------------------------"); //Max
        integers.stream().reduce((x, y) -> x > y ? x : y).ifPresent(System.out::println);
        System.out.println(integers.stream().reduce(Integer::max));
    }
}
