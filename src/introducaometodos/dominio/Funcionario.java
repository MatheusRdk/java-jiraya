package introducaometodos.dominio;

public class Funcionario {
    private String nome;
    private int idade;
    private double[] salario;
    private double soma;

    public void imprimeDados() {
        System.out.println("Nome: " + this.nome);
        System.out.println("Idade: " + this.idade);
        System.out.print("Salários: ");
        if (salario != null) {
            for (double salarios : salario) {
                System.out.print(salarios + " | ");
            };
        } else {
            System.out.print("Por favor insira os salários.");
        }
        mediaSalario();
    }


    public void mediaSalario() {
        if (salario == null) {
            return;
        }
        System.out.println("\n-----------médiasalário-----------");
        for (double num : salario) {
            soma += num;
        }   
        System.out.println(soma/salario.length);
    }


    public void setNome(String nome) {
        this.nome = nome;
    }


    public void setIdade(int idade) {
        this.idade = idade;
    }


    public void setSalario(double[] salario) {
        this.salario = salario;
    }

    public String getNome() {
        return this.nome;
    }


    public int getIdade() {
        return this.idade;
    }


    public double[] getSalario() {
        return this.salario;
    }


    public double getSoma() {
        return this.soma;
    }  


    

    
}
