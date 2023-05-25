package academy.sobrescrita.dominio;

public class Anime extends Object { //Nao e obrigatorio o extends object para usar o override naquele metodo, pois todos sao subclasse de object.
    private String nome;

    @Override
    public String toString() {
        return "Anime: " + this.nome; //Esse metodo toString sempre é chamado quando printa alguma coisa, é da classe Object que é padrao do java. Vc usa a anotação Override para garantir
    }                                 //que está sobreescrevendo um método e nao criando outro. Para sobreescrever precisa ter a mesma quantidade de parametros, o mesmo tipo e nao pode ser mais
                                     // restritivo, como por exemplo mudar de public para protected.
    public Anime(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
    
    
}
