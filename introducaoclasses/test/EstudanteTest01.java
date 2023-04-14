package test;

import dominio.Estudante;

public class EstudanteTest01 {
    public static void main(String[] args) {
        Estudante estudante = new Estudante(); //O Estudante do lado esquerdo é a variável de referencia, e do lado direito é o objeto Estudante.
        estudante.nome = "Memeeeeeeeeeees";
        estudante.idade = 16;
        estudante.sexo = 'M';
        System.out.println(estudante.nome);
        System.out.println(estudante.idade);
        System.out.println(estudante.sexo);

        System.out.println("---------------------------------------");
        
        Estudante estudante2 = new Estudante(); //O Estudante do lado esquerdo é a variável de referencia, e do lado direito é o objeto Estudante.
        estudante2.nome = "MMMMMMMmmm";
        estudante2.idade = 18;
        estudante2.sexo = 'F';
        System.out.println(estudante2.nome);
        System.out.println(estudante2.idade);
        System.out.println(estudante2.sexo);
    }
}
