package modificadorestatico.dominio;


public class Carro {
    private String nome;
    private double velocidadeMaxima;
    private static double velocidadeLimite;  //O modificador estático faz o atributo pertencer a classe, nao mais ao objeto.
                                                  //Vc usa isso quando quer criar um atributo que seja igual em todas as classes, e acessa com o nome da classe, ex.: Carro.velocidadeLimite
                                                  
    public Carro(String nome, double velocidadeMaxima) {
        this.nome = nome;
        this.velocidadeMaxima = velocidadeMaxima;
    }   

    public static void setVelocidadeLimite(double velocidadeLimite){ //Dentro de métodos estáticos, nao pode usar variaveis nao estaticas, que sao as q usam this., pois elas podem nao existir
        Carro.velocidadeLimite = velocidadeLimite;                   //no código, e os metodos estaticos podem ser usados sem existir um objeto. 
    }

    public static double getVelocidadeLimite(){
        return Carro.velocidadeLimite;
    }


    public void imprime() {
        System.out.println("------------------------------");
        System.out.println("Nome: " + this.nome);
        System.out.println("Velocidade maxima: " + this.velocidadeMaxima);
        System.out.println("Velocidade limite: " + Carro.velocidadeLimite);
    }


    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public double getVelocidadeMaxima() {
        return velocidadeMaxima;
    }
    public void setVelocidadeMaxima(double velocidadeMaxima) {
        this.velocidadeMaxima = velocidadeMaxima;
    }
}


