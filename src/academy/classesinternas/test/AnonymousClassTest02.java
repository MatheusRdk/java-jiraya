package academy.classesinternas.test;

import academy.generics.dominio.Barco;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class AnonymousClassTest02 {
    public static void main(String[] args) {
        List<Barco> barcoList = new ArrayList<>(List.of(new Barco("Bmwarco"), new Barco("Barqueto"))); //Aqui vmos fazer um comparator como classe anonima, pra n precisar fazer outra classe
        //que tenha um comparator.
        barcoList.sort(new Comparator<Barco>() {
            @Override
            public int compare(Barco o1, Barco o2) {
                return o1.getNome().compareTo(o2.getNome());
            }
        });
        System.out.println(barcoList);
    }
}
