package academy.generics.test;

import academy.generics.servico.BarcoRentavelService;
import academy.generics.dominio.Barco;

public class ClasseGenericaTest02 {
    public static void main(String[] args) {
        BarcoRentavelService barcoRentavelService = new BarcoRentavelService();
        Barco barco = barcoRentavelService.buscaBarcoDisponivel();
        System.out.println("Usando barco por um mês................");
        barcoRentavelService.retornarBarcoAlugado(barco);

    }
}


