package associacao.test;

import associacao.dominio.Jogador;
import associacao.dominio.Time;

public class JogadorTest02 {
    public static void main(String[] args) {
        Jogador jogador1 = new Jogador("Peléeeé");
        Time time1 = new Time("Seleção Brasileira de Futebol ol ol");
        jogador1.setTime(time1);
        jogador1.imprime();
    }
}
