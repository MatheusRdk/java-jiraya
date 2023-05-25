package academy.classesabstratas.dominio;

public class Gerente extends Funcionario {

    public Gerente(String nome, double salario) {
        super(nome, salario);
    }

    @Override
    public String toString() {
        return "Gerente [nome= " + nome + ", salario= " + salario + "]";
    }

    @Override
    public void calculaBonus() { //Se houver um metodo abstrato na superclasse, as classes que sao extensoes precisam ter o metodo dessa forma, mesmo que nao faça nada.

    }

	@Override
	public void imprime() { //Como funcionario é uma extensão de pessoa, ele precisa usar o metodo abstrato que tem na pessoa, ou ser uma classe abstrata, como é o caso do Funcionario.
	}

}
