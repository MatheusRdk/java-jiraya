package academy.comportamento.interfaces;

import academy.comportamento.dominio.Car;

@FunctionalInterface   //Isso aqui define que é uma interface funcional. Ela só pode ter um método abstrato. E para utilizar lambdas vc precisa delas.
//Lambdas sao anonimas, funções, concisas.

public interface CarPredicate {
    boolean test(Car car);
}
