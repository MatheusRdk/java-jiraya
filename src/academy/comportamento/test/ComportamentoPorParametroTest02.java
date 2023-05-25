package academy.comportamento.test;

import academy.comportamento.dominio.Car;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class ComportamentoPorParametroTest02 {

    public static void main(String[] args) {
        List<Car> cars = List.of(new Car("green", 2011), new Car("black", 1999), new Car("red", 2019));
//        List<Car> greenCars = filter(cars, new CarPredicate() { //Aqui estamos criando uma subclasse com a interface que filtra para o verdes. O método está la embaixo, e a interface
//            @Override                                           //somente define o que o test vai fazer
//            public boolean test(Car car) {
//                return car.getColor().equals("green");
//            }
//        });

        List<Car>greenCars = filter(cars, car -> car.getColor().equals("green"));  //Tudo aquilo de cima virou isso aqui. É uma forma mais curta de criar aquilo.
        List<Car>redCars = filter(cars, car -> car.getColor().equals("red"));   //A lógica vc cria em uma linha
        List<Car>carByYearBefore = filter(cars, car -> car.getYear() < 2015);
        System.out.println(greenCars);
        System.out.println(redCars);
        System.out.println(carByYearBefore);
    }

    private static List<Car> filter(List<Car> cars, Predicate<Car> carPredicate) { //Em vez de criar a CarPredicate, use a Predicate do java que já faz isso.
        List<Car> filteredCars = new ArrayList<>();
        for (Car car : cars) {
            if (carPredicate.test(car)) {
                filteredCars.add(car);
            }
        }
        return filteredCars;
    }
}
