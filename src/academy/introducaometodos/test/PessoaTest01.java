package academy.introducaometodos.test;

import academy.introducaometodos.dominio.Pessoa;

public class PessoaTest01 {
    public static void main(String[] args) {
        Pessoa pessoa = new Pessoa();
        //pessoa.nome = "Matheus";
        //pessoa.idade = 22;      //Quando você deixa privado esses atributos, precisa criar um método para acessalos e mudalos, que é esse setNome e setIdade.
        pessoa.setNome("Matheus");
        pessoa.setIdade(15);
       // pessoa.imprime();
        System.out.println(pessoa.getIdade()); //Com esses métodos get, você retorna os nomes.
        System.out.println(pessoa.getNome());
    }
}
