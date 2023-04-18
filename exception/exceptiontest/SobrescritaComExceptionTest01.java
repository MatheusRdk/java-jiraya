package exception.exceptiontest;

import exception.dominio.Funcionario;
import exception.dominio.LoginInvalidoException;
import exception.dominio.Pessoa;

public class SobrescritaComExceptionTest01 {
    public static void main(String[] args) {
        Pessoa pessoa = new Pessoa();
        Funcionario funcionario = new Funcionario();
        System.out.println(pessoa);

        try {
            funcionario.salvar();
        } catch (LoginInvalidoException e) {
            e.printStackTrace();
        }
    }
}
