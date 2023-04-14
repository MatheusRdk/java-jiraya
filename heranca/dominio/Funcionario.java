package heranca.dominio;

public class Funcionario extends Pessoa { //Isso é herança, todos os atributos da pessoa o funcionário vai ter, pois e uma extensão da pessoa.
    private double salario;

    static{
        System.out.println("Dentro do bloco de inicializaçao estático de funcionario");
    }
    
    {
        System.out.println("Dentro do bloco de inicializaçao de funcionario 1");
    }

    {
        System.out.println("Dentro do bloco de inicializaçao de funcionario 2");
    }

    public Funcionario(String nome, String cpf) {
        super(nome, cpf); //Pegando o construtor da classe principal
        System.out.println("Dentro do construtor de funcionario");
    }

    public void imprime(){
        super.imprime(); //Esse é o meio de acessar o método da classe que foi extendida. Isso é tipo sobrecarga de método.
        System.out.println("Salário: " + this.salario);
    }

    public void relatorioPagamento(){
        System.out.println("--------------");
        System.out.println("Nome: " + this.nome + ", Salário: " + this.salario); //Se esses atributos da pessoa forem protected, vc pode acessar pela extensão com o this, como se estivesse aqui
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }
    
}
