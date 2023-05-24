package construtores.dominio;

public class Animes {
    private String nome;
    private String tipo;
    private int episodios;
    private String genero;
    private String estudio;

    public Animes(String nome, String tipo, int episodios, String genero){    //Quando cria o objeto anime, o construtor obriga a inicializar com esses valores.
        this();  //Essa forma so e usada para chamar construtor. O this deve ser a primeira linha executavel, nao pode ter nada antes, quando for chamar construtor com ele.
        this.nome = nome;
        this.tipo = tipo;                                //PARA SER UM CONSTRUTOR NAO PODE TER NEM TIPO NEM VOID, TEM Q SER O NOME DA CLASSE E MAIS NADA
        this.episodios = episodios;
        this.genero = genero;
    }

    public Animes(String nome, String tipo, int episodios, String genero, String estudio){
        this(nome, tipo, episodios, genero);
        this.estudio = estudio;
    }

    public Animes(){                         //Essa sobrecarga de construtores possibilita que o objeto tambem possa ser inicializado sem nada.
        System.out.println("TESTE Construtor sem nada");
    }

    public void imprime(){
        System.out.println(this.nome);
        System.out.println(this.tipo);
        System.out.println(this.episodios);
        System.out.println(this.genero);
        System.out.println(this.estudio);
    }

    public String getNome(){
        return this.nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTipo() {
        return this.tipo;
    }

    public void setTipo(String tipo){
        this.tipo = tipo;
    }

    public int getEpisodios() {
        return this.episodios;
    }

    public void setEpisodios(int episodios) {
        this.episodios = episodios;
    }

    public String getGenero() {
        return this.genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

}
