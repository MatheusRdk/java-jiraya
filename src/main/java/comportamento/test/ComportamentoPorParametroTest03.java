package comportamento.test;

import comportamento.dominio.Car;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class ComportamentoPorParametroTest03 {

    public static void main(String[] args) {
        List<Car> cars = List.of(new Car("green", 2011), new Car("black", 1999), new Car("red", 2019));
        List<Car>greenCars = filter(cars, car -> car.getColor().equals("green"));  //Tudo aquilo de cima virou isso aqui. É uma forma mais curta de criar aquilo.
        List<Car>redCars = filter(cars, car -> car.getColor().equals("red"));   //A lógica vc cria em uma linha
        List<Car>carByYearBefore = filter(cars, car -> car.getYear() < 2015);
        System.out.println(greenCars);
        System.out.println(redCars);
        System.out.println(carByYearBefore);
        System.out.println("-----------------------------------");

        List<Integer> nums = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10); //Isso se chama lambda, é uma sintaxe mais enxuta pras classes anonimas (feitas na hora da chamada).
        System.out.println(filter(nums, num -> num % 2 == 0)); //Pares
    }

    private static <T> List<T> filter(List<T> list, Predicate<T> predicate){ //Perceba que todos os métodos feitos antes ainda funcionam.
        List<T> filteredList = new ArrayList<>();
        for (T e : list){
            if(predicate.test(e)){
                filteredList.add(e);
            }
        }
        return filteredList;
    }
}
