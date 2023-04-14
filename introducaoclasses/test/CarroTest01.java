package test;

import dominio.Carro;

public class CarroTest01 {
    public static void main(String[] args) {
        Carro carro1 = new Carro();
        Carro carro2 = new Carro();

        carro1.nome = "Sapo louco";
        carro1.modelo = "Gol quadrado";
        carro1.ano = 1996;
        
        carro2.nome = "Sapo menos louco";
        carro2.modelo = "Gol bolinha";
        carro2.ano = 1999;
        System.out.println(carro1.nome + " - " + carro1.modelo + " - " + carro1.ano + "\n" + "-------------------------------------" + "\n" + carro2.nome + " - " + carro2.modelo + " - " + carro2.ano);
    }
}
