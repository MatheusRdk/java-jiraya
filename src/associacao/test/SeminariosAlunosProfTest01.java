package associacao.test;

import associacao.dominio.Aluno;
import associacao.dominio.Local;
import associacao.dominio.Professor;
import associacao.dominio.Seminario;

public class SeminariosAlunosProfTest01 {
    public static void main(String[] args) {
        Aluno aluno1 = new Aluno("Matheus", 250);
        Aluno aluno2 = new Aluno("Juuuuuubileu", 267);
        Aluno[] alunos = {aluno1, aluno2};

        Local localidade1 = new Local("Priquilandia");	
        Local localidade2 = new Local("XUmbecolandia");

        Professor professor1 = new Professor("MATHEUSSZS", "Memes");
        Professor professor2 = new Professor("KKKKKAkazshi hatake", "Jutsu bola de foogos");

        Seminario seminario1 = new Seminario("Como fazer memes todos os dias em um padrão helicopteral", localidade2);
        Seminario seminario2 = new Seminario("Como fazer o justus bola de foooogo", localidade1);
        Seminario seminario3 = new Seminario("Memes. Um paradigma para o Digma", localidade1);

        Seminario[] seminarios1 = {seminario2};
        Seminario[] seminarios2 = {seminario1, seminario3};

        aluno1.setSeminario(seminario1);
        aluno2.setSeminario(seminario2);

        professor2.setSeminarios(seminarios1);
        professor1.setSeminarios(seminarios2);

        seminario1.setAluno(alunos);

        System.out.println("------------------alunos------------------");
        aluno1.imprime();
        aluno2.imprime();

        System.out.println("------------------professores------------------");
        professor1.imprime();
        professor2.imprime();

        System.out.println("------------------seminarios------------------");
        seminario1.imprime();
        seminario2.imprime();
        seminario3.imprime();
        
        System.out.println("------------------locais------------------");
        localidade1.imprime();
        localidade2.imprime();


    }
}
