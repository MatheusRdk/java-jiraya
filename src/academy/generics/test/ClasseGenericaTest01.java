package academy.generics.test;

import academy.generics.dominio.Carro;
import academy.generics.servico.CarroRentavelService;

public class ClasseGenericaTest01 {
    public static void main(String[] args) {
        CarroRentavelService carroRentavelService = new CarroRentavelService();
        Carro carro = carroRentavelService.buscaCarroDisponivel();
        System.out.println("Usando carro por um mês................");
        carroRentavelService.retornarCarroAlugado(carro);

    }
}
