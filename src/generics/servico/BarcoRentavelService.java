package generics.servico;

import generics.dominio.Barco;

import java.util.ArrayList;
import java.util.List;

public class BarcoRentavelService {  //Para copiar a classe e mudar os nomes vai de Ctrl+c, Ctrl+f, Ctrl+r, ai clica no W se quiser só maiuscula ou minuscula primeira letra. E só vai.
    private List<Barco> barcosDisponiveis = new ArrayList<>(List.of(new Barco("Lancha"), new Barco("Canoa"))); //Usa o arrayList pra poder mudar a lista depois.

    public Barco buscaBarcoDisponivel(){
        System.out.println("Buscando barco disponível....");
        Barco barco = barcosDisponiveis.remove(0); //Removendo o primeiro barco, index 0
        System.out.println("Alugando barco: " + barco);
        System.out.println("Barcos disponíveis para alugar:");
        System.out.println(barcosDisponiveis);
        return barco;
    }
                                                                              //Estamos tirando o barco de uma lista e depois com outro método retornando ele.
    public void retornarBarcoAlugado(Barco barco){
        System.out.println("Devolvendo barco " + barco + ".....");
        barcosDisponiveis.add(barco);
        System.out.println("Barcos disponíveis para alugar:");
        System.out.println(barcosDisponiveis);
    }
}
