package academy.generics.test;

import academy.generics.dominio.Barco;
import academy.generics.dominio.Carro;
import academy.generics.servico.RentalService;

import java.util.ArrayList;
import java.util.List;

public class ClasseGenericaTest03 {
    public static void main(String[] args) {
        List<Carro> carrosDisponiveis = new ArrayList<>(List.of(new Carro("BMW"), new Carro("Mercedez")));
        List<Barco> barcosDisponiveis = new ArrayList<>(List.of(new Barco("Lancha"), new Barco("Canoa")));
        RentalService<Carro> rentalService = new RentalService<>(carrosDisponiveis);  //Criamos um rentalService para cada classe, perceba que o T e o t agora sao o que vc passar ali.
        Carro carro = rentalService.buscaObjetoDisponivel();
        System.out.println("Usando carro por um mês.......");
        rentalService.retornarObjetoAlugado(carro);
        System.out.println("------------------------------------");
        RentalService<Barco> rentalService2 = new RentalService<>(barcosDisponiveis);
        Barco barco = rentalService2.buscaObjetoDisponivel();
        System.out.println("Usando barco por um mês.......");
        rentalService2.retornarObjetoAlugado(barco);
    }
}


