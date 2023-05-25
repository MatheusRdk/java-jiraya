package academy.associacao.test;

import academy.associacao.dominio.Escola;
import academy.associacao.dominio.Professor;

public class EscolaTest01 {
    public static void main(String[] args) {
        Professor professor1 = new Professor("KAKASHI", "Memes");
        Escola escola1 = new Escola("NARUTOMUNDO");
        Professor[] professores = {professor1};
        escola1.setProfessores(professores);

        escola1.imprime();
    }
    
}
