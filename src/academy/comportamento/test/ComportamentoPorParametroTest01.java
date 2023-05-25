package academy.comportamento.test;

import academy.comportamento.dominio.Car;

import java.util.ArrayList;
import java.util.List;

public class ComportamentoPorParametroTest01 {   //Conforme o cliente for pedindo, vc fica fazendo novos métodos parecidos para alcançar o objetivo.
    private static List<Car> filterGreenCars(List<Car> cars) {
        List<Car> greenCars = new ArrayList<>();
        for (Car car : cars) {
            if (car.getColor() == "green") {
                greenCars.add(car);
            }
        }
        return greenCars;
    }

    private static List<Car> filterRedCars(List<Car> cars) {
        List<Car> redCars = new ArrayList<>();
        for (Car car : cars) {
            if (car.getColor() == "red") {
                redCars.add(car);
            }
        }
        return redCars;
    }

    private static List<Car> filterByYearBefore(List<Car> cars, int year) {
        List<Car> filteredCars = new ArrayList<>();
        for (Car car : cars) {
            if (car.getYear() == year) {
                filteredCars.add(car);
            }
        }
        return filteredCars;
    }


    public static void main(String[] args) {
        List<Car> cars = List.of(new Car("green", 2011), new Car("black", 1999), new Car("red", 2019));
        System.out.println(filterGreenCars(cars));
    }
}
