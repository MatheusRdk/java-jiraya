package academy.introducaometodos.test;

import academy.introducaometodos.dominio.Funcionario;

public class funcionarioTest01 {
    public static void main(String[] args) {
        Funcionario funcionario01 = new Funcionario();
        funcionario01.setNome("Norberto");
        funcionario01.setIdade(86);
        funcionario01.setSalario(new double[] {4000, 3100, 2159.59});
        funcionario01.imprimeDados();
    }    
}
