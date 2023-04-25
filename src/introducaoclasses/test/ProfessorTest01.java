package test;

import dominio.Professor;

public class ProfessorTest01 {
    public static void main(String[] args) {
        Professor professor = new Professor();
        professor.nome = "Profsor";
        professor.idade = 22;
        professor.sexo = 'F';
        System.out.println(professor.nome + " " + professor.idade + " " + professor.sexo);
    }
}
