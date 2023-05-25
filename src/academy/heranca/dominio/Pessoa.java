package academy.heranca.dominio;

public class Pessoa {
    protected String nome; //Quando vc faz ele protected, os que sao extensoes de Pessoa, como o Funcionario, podem acessar o atributo como se fosse public.
    protected String cpf;  //Ele só pode ser acessado em qualquer lugar pelas subclasses, e se nao for subclasse pode ser acessado se estiver no mesmo pacote (nesse caso, dominio).
    protected Endereco endereco;

    static{
        System.out.println("Dentro do bloco de inicializaçao estático de pessoa");
    }
    
    {
        System.out.println("Dentro do bloco de inicializaçao de pessoa 1");
    }

    {
        System.out.println("Dentro do bloco de inicializaçao de pessoa 2");
    }
    
    public Pessoa(String nome, String cpf) {
        System.out.println("Dentro do construtor de pessoa");
        this.nome = nome;
        this.cpf = cpf;
    }

    public void imprime(){
        System.out.println("-----------");
        System.out.println("Nome: " + this.nome);
        System.out.println("CPF: " + this.cpf);
        if (endereco == null) return;
        System.out.println("Endereço: " + endereco.getRua() + ", " + endereco.getCep());
    }

    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public String getCpf() {
        return cpf;
    }
    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
    public Endereco getEndereco() {
        return endereco;
    }
    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    
}
