package academy.padroesdeprojeto.test;

import academy.padroesdeprojeto.dominio.Pessoa;

public class BuilderPatternTest01 { //PADRAO BUILDER. O objetivo é melhorar a leitura, fica mais facil de entender. Tem o plugin buildergenerator pra fazer tudo isso.

    public static void main(String[] args) {
        //Pessoa pessoa = new Pessoa("Matheus", "Rudek", "MR", "matheus.rdk@gmail.com"); Assim nao funciona mais pq é private
        Pessoa pessoa = new Pessoa.PessoaBuilder()
                .firstName("Matheus")
                .lastName("Rudek")
                .userName("MR")
                .email("matheus.rdk@gmail.com")
                .build();

        System.out.println(pessoa);

    }
}
