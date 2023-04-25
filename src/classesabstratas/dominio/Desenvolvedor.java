package classesabstratas.dominio;

public class Desenvolvedor extends Funcionario {

    public Desenvolvedor(String nome, double salario) {
        super(nome, salario);
    }

    @Override
    public String toString() {
        return "Desenvolvedor [nome= " + nome + ", salario= " + salario + "]";
    }

    @Override
    public void calculaBonus() {
        this.salario = this.salario * 1.5; 
    }

	@Override
	public void imprime() {
	}
    
    
    
}
