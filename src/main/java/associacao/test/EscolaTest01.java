package associacao.test;

import associacao.dominio.Escola;
import associacao.dominio.Professor;

public class EscolaTest01 {
    public static void main(String[] args) {
        Professor professor1 = new Professor("KAKASHI", "Memes");
        Escola escola1 = new Escola("NARUTOMUNDO");
        Professor[] professores = {professor1};
        escola1.setProfessores(professores);

        escola1.imprime();
    }
    
}
