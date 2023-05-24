package generics.servico;

import generics.dominio.Barco;

import java.util.ArrayList;
import java.util.List;

public class RentalService<T> { //Vc coloca o T para ser uma classe genérica. Assim vc nao precisa ficar criando métodos e classes para cada tipo.
    private List<T> objetosDisponiveis;

    public RentalService(List<T> objetosDisponiveis) {
        this.objetosDisponiveis = objetosDisponiveis;
    }

    public T buscaObjetoDisponivel(){
        System.out.println("Buscando objeto disponível....");
        T t = objetosDisponiveis.remove(0);
        System.out.println("Alugando objeto: " + t);
        System.out.println("Objetos disponíveis para alugar:");
        System.out.println(objetosDisponiveis);
        return t;
    }
    public void retornarObjetoAlugado(T t){
        System.out.println("Devolvendo objeto " + t + ".....");
        objetosDisponiveis.add(t);
        System.out.println("Objetos disponíveis para alugar:");
        System.out.println(objetosDisponiveis);
    }
}
