package test;

import dominio.Estudante;
//Estudante sem usar a classe Imprime, mas o método do próprio estudante.


public class estudanteTest02 {
    public static void main(String[] args) {
        
        Estudante estudante01 = new Estudante();
        Estudante estudante02 = new Estudante();

        estudante01.nome = "Middddddle";
        estudante01.idade = 18;
        estudante01.sexo = 'M';

        estudante02.nome = "MMMMMMmmmmmmbombs";
        estudante02.idade = 79;
        estudante02.sexo = 'F';

        estudante01.imprime(); //método imprime do próprio estudante.
        estudante02.imprime();

    }
    
}
