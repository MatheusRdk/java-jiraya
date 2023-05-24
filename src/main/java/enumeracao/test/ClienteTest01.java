package enumeracao.test;

import enumeracao.dominio.Cliente;
import enumeracao.dominio.TipoCliente;
import enumeracao.dominio.TipoPagamento;

public class ClienteTest01 {
    public static void main(String[] args) {
        Cliente cliente1 = new Cliente("Amamaskak",TipoCliente.PESSOA_JURIDICA, TipoPagamento.CREDITO);
        Cliente cliente2 = new Cliente("Leucopecppp", TipoCliente.PESSOA_FISICA, TipoPagamento.DEBITO); //Nao usa mais string, quando e um enumerate ele da as opçoes quando vc escreve a classe.
        System.out.println(cliente1);
        System.out.println(cliente2);
        System.out.println("-----------------");
        System.out.println(TipoPagamento.CREDITO.calcularDesconto(1500));
        System.out.println(TipoPagamento.DEBITO.calcularDesconto(1500));

        System.out.println(TipoCliente.tipoClientePorNomeRelatorio("Pessoa Juridica")); //Usando o metodo do TipoCliente que retorna o nome do enum pelo nome do atributo.




    }
}
