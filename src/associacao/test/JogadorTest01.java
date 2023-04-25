package associacao.test;

import associacao.dominio.Jogador;

public class JogadorTest01 {
    public static void main(String[] args) {
        Jogador jogador1 = new Jogador("Pelé");
        Jogador jogador2 = new Jogador("Aristzabal");
        Jogador jogador3 = new Jogador("Xicoico");
    
        Jogador[] jogadores = {jogador1, jogador2, jogador3};               //Cada espaço do array jogadores faz referencia pros mesmos objetos que o jogador1, 2 e 3. Ex.:
                                                                            //o espaço 0 do array faz referencia pro mesmo objeto em memória que o jogador1.
        for (Jogador jogo : jogadores){
            jogo.imprime();
        }     
    }
}

