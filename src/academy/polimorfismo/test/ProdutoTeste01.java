package academy.polimorfismo.test;

import academy.polimorfismo.dominio.Computador;
import academy.polimorfismo.dominio.Produto;
import academy.polimorfismo.dominio.Tomate;
import academy.polimorfismo.servico.CalculadoraImposto;

public class ProdutoTeste01 {
    public static void main(String[] args) {
        Computador computador = new Computador("Windows 11 com muita potência roda até cs", 2500);
        Tomate tomate = new Tomate("Tomate cereja roda até lol", 15);

        CalculadoraImposto.calcularImposto(computador);
        System.out.println("--------------------");
        CalculadoraImposto.calcularImposto(tomate);

        Produto produto = new Tomate("Tomate cru", 100);
        //produto.getDataValidade();  a classe produto, que e a variavel de referencia aqui, nao acessa o metodo getDataValidade pois é exclusivo do tomate.
        //O tomate tem tudo o que o produto tem, pois é um produto, mas ainda tem mais coisas, que sao do tomate apenas. E o método calcularImpostoTomate recebe um tomate, nao apenas um produto.
        System.out.println("--------------------");
        System.out.println(produto);

        // Whitening cast: ocorre quando um objeto é convertido de uma classe mais específica para uma classe mais genérica. Por exemplo, se uma classe "Cachorro" estende a classe "Animal", 
        //um objeto "Cachorro" pode ser convertido em um objeto "Animal" usando um whitening cast. Esse tipo de cast é seguro e não resulta em perda de informações, já que o objeto continua 
        //sendo do tipo "Cachorro" em tempo de execução.

        //Narrowing cast: ocorre quando um objeto é convertido de uma classe mais genérica para uma classe mais específica. Por exemplo, se um objeto "Animal" é convertido em um objeto "Cachorro", 
        //pode ocorrer uma perda de informações, já que nem todo objeto "Animal" é um objeto "Cachorro". Esse tipo de cast pode gerar erros em tempo de execução se o objeto não puder ser convertido 
        //corretamente.
    }
}
