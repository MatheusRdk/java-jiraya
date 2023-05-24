package generics.servico;

import generics.dominio.Carro;

import java.util.ArrayList;
import java.util.List;

public class CarroRentavelService {
    private List<Carro> carrosDisponiveis = new ArrayList<>(List.of(new Carro("BMW"), new Carro("Mercedez"))); //Usa o arrayList pra poder mudar a lista depois.

    public Carro buscaCarroDisponivel(){
        System.out.println("Buscando carro disponível....");
        Carro carro = carrosDisponiveis.remove(0); //Removendo o primeiro carro, index 0
        System.out.println("Alugando carro: " + carro);
        System.out.println("Carros disponíveis para alugar:");
        System.out.println(carrosDisponiveis);
        return carro;
    }
                                                                              //Estamos tirando o carro de uma lista e depois com outro método retornando ele.
    public void retornarCarroAlugado(Carro carro){
        System.out.println("Devolvendo carro " + carro + ".....");
        carrosDisponiveis.add(carro);
        System.out.println("Carros disponíveis para alugar:");
        System.out.println(carrosDisponiveis);
    }

}
