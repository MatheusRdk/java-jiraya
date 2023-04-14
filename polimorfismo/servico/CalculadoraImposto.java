package polimorfismo.servico;

import polimorfismo.dominio.Produto;
import polimorfismo.dominio.Tomate;

public class CalculadoraImposto {

    public static void calcularImposto(Produto produto){ //De acordo com as regras de polimorfismo, esse metodo vai pegar um produto e seus atributos, e o tomate e o pc sao produtos.
        System.out.println("Relatório de impostos");     //Vc nao precisa criar um metodo pro Tomate e pro PC, mas um que recebe um PRODUTO.
        double imposto = produto.calcularImposto();
        System.out.println("Prduto: " + produto.getNome());
        System.out.println("Valor: " + produto.getValor());
        System.out.println("Imposto a ser pago: " + imposto);
        if (produto instanceof Tomate){ //Para executar coisas conforme o tipo do objeto, usa esse instaceof, assim, se o OBJETO for uma instancia de tomate, ele executa o codigo.
            Tomate tomate = (Tomate) produto; //Vc faz casting do produto como sendo tomate. 
            System.out.println("Data de validade: " + tomate.getDataValidade());
        }
    }
}
