package academy.blocosdeinicializacao.dominio;
public class Anime {
    private String nome;
    private int[] episodios;

    {
        System.out.println("Dentro do bloco de inicialização");   //Bloco de inicialização de instancia. Serve pra fazer alguma coisa antes de qualquer coisa.
        episodios = new int[100];
        for (int i = 0; i < episodios.length; i++) {
            episodios[i] = i + 1;
        }
        for (int episodio: this.episodios) {                                         // Sequencia da inicialização da classe:
            System.out.print(episodio + " ");                                        // 1 - Alocado espaço em memória pro objeto;
        }                                                                            // 2 - Cada atributo de classe é criado e inicializado com valores default ou passados;
    }                                                                                // 3 - Bloco de inicialização é executado;
                                                                                     // 4 - Construtor é executado.
    public Anime(String nome) {
        this.nome = nome;
        System.out.println();
    }

    public Anime() {
        System.out.println();
    }

    public String getNome() {
        return nome;
    }

    public int[] getEpisodios() {
        return episodios;
    }

    
}
