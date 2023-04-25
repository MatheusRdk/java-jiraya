package modificadorestatico.dominio;


public class Anime {
    private String nome;
    private static int[] episodios;

    static {
        System.out.println("Dentro do bloco de inicialização");   //Bloco de inicialização de instancia. Serve pra fazer alguma coisa antes de qualquer coisa.
        episodios = new int[100];                                   //Quando o bloco é estático, ele aparece apenas uma vez, mesmo que tenha várias instâncias da classe no código.
        for (int i = 0; i < episodios.length; i++) {                //Pode fazer vários blocos, eles serão executados na sequencia que aparecem aqui.
            episodios[i] = i + 1;
        }                                                                                    // Sequencia da inicialização da classe:                                                    
    }                                                                                // 0 - Bloco de inicialização é executado quando a JVM carregar a classe;
                                                                                     // 1 - Alocado espaço em memória pro objeto;
    public Anime(String nome) {                                                      // 2 - Cada atributo de classe é criado e inicializado com valores default ou passados;
        this.nome = nome;                                                            // 3 - Bloco de inicialização é executado;
        System.out.println(this.nome);                                               // 4 - Construtor é executado.
    }

    public Anime() {
        for (int episodio: Anime.episodios) {                                           
            System.out.print(episodio + " ");                                        
        } 
        System.out.println();
    }

    public String getNome() {
        return nome;
    }

    public static int[] getEpisodios() {
        return Anime.episodios; 
    }
}
