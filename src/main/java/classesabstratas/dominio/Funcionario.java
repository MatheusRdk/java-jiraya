package classesabstratas.dominio;

public abstract class Funcionario extends Pessoa { //Quando a classe é abstrata, vc so pode usar as classes que sao extensoes, como o gerente, mas nao essa mesma.
    protected String nome;         //Uma classe abstrata foi criada PARA ser uma superclasse.
    protected double salario;

    
    public Funcionario(String nome, double salario) {
        this.nome = nome;
        this.salario = salario;
        calculaBonus();
    }

    public abstract void calculaBonus(); //Metodo abstrato, é usado por todas as classes q sao extensoes do funcionario, e vc pode sobreescrever elas em cada um para mudar os valores por ex.
}
