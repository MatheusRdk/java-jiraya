package academy.introducaometodos.dominio;

public class Estudante {
    public String nome;   //Você pode iniciar com um valor, ai todos que forem da classe Estudante vao começar com ele, ex.: public String nome = "Matheus";
    public int idade;
    public char sexo;

    public void imprime(){
        System.out.println("-------------------------");
        System.out.println(this.nome);
        System.out.println(this.idade);
        System.out.println(this.sexo);
    }
}
