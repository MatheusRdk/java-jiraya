package associacao.test;

import associacao.dominio.Jogador;
import associacao.dominio.Time;

public class JogadorTest03 {
    public static void main(String[] args) {
        Jogador jogador1 = new Jogador("Cafu");
        Jogador jogador2 = new Jogador("Peléléé");
        Time time1 = new Time("ZANZIBAR");
        Jogador[] jogadores = {jogador1, jogador2};
        jogador2.setTime(time1);
        jogador1.setTime(time1);
        time1.setJogadores(jogadores);

        System.out.println("----ponto de vista do Time----");
        time1.imprime();
        
        System.out.println("----ponto de vista do Jogador1----");
        jogador1.imprime();
        
        System.out.println("----ponto de vista do Jogador2----");
        jogador2.imprime();
    }
}
