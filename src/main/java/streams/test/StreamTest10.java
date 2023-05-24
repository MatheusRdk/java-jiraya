package streams.test;

import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Stream;

public class StreamTest10 {
    public static void main(String[] args) {
        //Stream iterate
        Stream.iterate(1, n -> n + 2) //o iterate gera streams infinitamente, até vc parar ou ja deixar definido onde para.
                .limit(100)
                .forEach(System.out::println);
        System.out.println("------------------");

        //0, 1, 1, 2, 3, 5, 8, 13, 21, 34 -> Fibonacci
        //(0, 1) (1,1) (1, 2) (2, 3) (3, 5) (5, 8) (8, 13) (13, 21) (21, 34)
        Stream.iterate(new int[]{0, 1}, n -> new int[]{n[1], n[0] + n[1]}) //Vc pode por o formato que quiser ali no seed, nao precisa ser 1.
                .limit(5)
                .forEach(a -> System.out.println(Arrays.toString(a))); //O a representa o array.

        Stream.iterate(new int[]{0, 1}, n -> new int[]{n[1], n[0] + n[1]})
                .limit(5)
                .map(a -> a[0])
                .forEach(System.out::println);
        System.out.println("------------------");


        //Stream generate
        ThreadLocalRandom random = ThreadLocalRandom.current(); //Forma de gerar numeros aleatórios.
        Stream.generate(() -> random.nextInt(1, 500))//Gerando 20 numeros aleatórios de 1 a 500.
                .limit(10)
                .forEach(System.out::println);
    }
}
