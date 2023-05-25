package academy.heranca.test;

import academy.heranca.dominio.Funcionario;
import academy.heranca.dominio.Pessoa;
import academy.heranca.dominio.Endereco;

public class HerancaTeste01 {
    public static void main(String[] args) {

        Endereco endereco = new Endereco();
        endereco.setRua("Rua das caieiras");
        endereco.setCep("85500-000");

        Pessoa pessoa = new Pessoa("Shingeki Kyojin", "114.276.317-50");
        pessoa.setEndereco(endereco);
        pessoa.imprime();

        Funcionario funcionario = new Funcionario("Orararara", "156.125.479-77" );
        funcionario.setEndereco(endereco);
        funcionario.setSalario(1000000);
        funcionario.imprime();
        funcionario.relatorioPagamento();
    }
}
