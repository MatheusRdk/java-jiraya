package classesabstratas.test;

import classesabstratas.dominio.Desenvolvedor;
import classesabstratas.dominio.Gerente;

public class FuncionarioTest01 {
    public static void main(String[] args) {
        //Funcionario funcionario = new Funcionario("Moooololo", 52000); //Como a classe funcionario e abstrata, nao da pra criar um objeto funcionario
        Gerente gerente = new Gerente("Birologogopa", 10000);
        System.out.println(gerente);
        Desenvolvedor desenvolvedor = new Desenvolvedor("Desenvolvovleov", 10000);
        System.out.println(desenvolvedor);
    }
    
}
