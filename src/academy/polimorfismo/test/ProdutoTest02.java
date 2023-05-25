package academy.polimorfismo.test;

import academy.polimorfismo.dominio.Computador;
import academy.polimorfismo.dominio.Produto;
import academy.polimorfismo.dominio.Tomate;

public class ProdutoTest02 {
    public static void main(String[] args) {

        Produto produto1 = new Computador("Ryzen 10", 1000); //As caracteristicas da variável produto1 sao de produto, mesmo sendo um computador. Por isso um metodo que recebe um computador
        //                                                                 nao vai aceitar esse produto1, pois a variavel de referencia vai dar apenas os atributos de produto, e nao o de computador,
        //                                                                  mesmo ele tendo essas caracteristicas.
        Produto produto2 = new Tomate("Tomate 10zao", 14);
        System.out.println(produto1);
        System.out.println(produto2);
    }
    
}
