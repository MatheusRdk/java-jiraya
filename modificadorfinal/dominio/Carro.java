package modificadorfinal.dominio;

public final class Carro { //Quando a classe é final, nao pode usar ela como superclasse
    private String nome;
    public static final double VELOCIDADE_LIMITE = 250;               //Constantes se escrevem dessa forma, e usa o final. Ela nao pode mais ser alterada, por isso e constante.
    public final Comprador COMPRADOR = new Comprador();               //Vc precisa inicializar a constante com algum valor, ou inicializar no bloco de inicialização estático.
                                                                 //          static{
                                                                //              VELOCIDADE_LIMITE = 1000;
                                                                //           }
                                                                      //Ou tambem pode ser inicilizada no construtor, pois ai ela tera um valor antes de ser usada. 
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }

    public final void imprime(){ //Dessa forma o método nao pode ser sobreescrito nas subclasses (se houver), pois é um método final.
        System.out.println(this.nome);
    }

}
