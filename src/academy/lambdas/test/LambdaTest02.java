package academy.lambdas.test;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

public class LambdaTest02 {
    public static void main(String[] args) {
        List<String> strings = List.of("NAtsu", "AlucAArd", "AgosTTinho");
        List<Integer> integers = map(strings, s -> s.length());//O length seria o retorno R, que é outro tipo diferente do s(T), nao necessariamente. Podem ser do mesmo tipo igual abaixo
        System.out.println(integers);
        List<String> map = map(strings, s -> s.toLowerCase());
        System.out.println(map);

    }

    //Usando a Function: Tem dois parametros, o T (tipo) e o R(retorno).
    private static <T, R> List<R> map(List<T> list, Function<T, R> function){
        List<R> result = new ArrayList<>();
        for (T e : list){
            R r = function.apply(e); //Recebe T e retorna R.
            result.add(r);
        }
        return result;
    }
}
