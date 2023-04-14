package polimorfismo.test;

import polimorfismo.dominio.Computador;
import polimorfismo.dominio.Produto;
import polimorfismo.dominio.Tomate;
import polimorfismo.servico.CalculadoraImposto;

public class ProdutoTeste03 {
    public static void main(String[] args) {
        Produto produto1 = new Computador("Compiuter", 8001);
        //Produto produto2 = new Tomate("mate", 8001);

        System.out.println(produto1);
        System.out.println("--------------------");
        Tomate tomate1 = new Tomate("Miricano", 1000.2);
        tomate1.setDataValidade("18-08-2023");
        CalculadoraImposto.calcularImposto(tomate1);
    }
}
