package generics.test;

import generics.dominio.Carro;
import generics.servico.CarroRentavelService;

public class ClasseGenericaTest01 {
    public static void main(String[] args) {
        CarroRentavelService carroRentavelService = new CarroRentavelService();
        Carro carro = carroRentavelService.buscaCarroDisponivel();
        System.out.println("Usando carro por um mês................");
        carroRentavelService.retornarCarroAlugado(carro);

    }
}
