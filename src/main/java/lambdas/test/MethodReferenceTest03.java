package lambdas.test;

import lambdas.dominio.Anime;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BiPredicate;
import java.util.function.Function;

//Reference to an instance method of an arbitrary object of a particular type
public class MethodReferenceTest03 {
    public static void main(String[] args) { //chamando através de um objeto
        List<String> list = new ArrayList<>(List.of("Memes", "Topmemes", "Dererememes"));
        list.sort(String::compareTo); //Mesmo o compareTo nao sendo estatico estamos chamando atraves do tipo da classe.
        System.out.println(list);
        Function<String, Integer> numStringToInteger = Integer::parseInt;
        System.out.println(numStringToInteger.apply("100")); //Recebe uma string e retorna um integer.

        //O BiPredicate é identico ao Predicate mas que recebe dois argumentos
        BiPredicate<List<String>, String> checkName = List::contains;
        System.out.println(checkName.test(list, "Topmemes"));
    }
}
