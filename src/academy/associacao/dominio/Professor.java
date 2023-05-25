package academy.associacao.dominio;

public class Professor {
    private String nome;
    private String especilidade;
    private Seminario[] seminarios;

    public Professor(String nome, String especilidade) {
        this.nome = nome;
        this.especilidade = especilidade;
    }

    public void imprime(){
        System.out.println("**************");
        System.out.println("Nome: " + this.nome);
        System.out.println("Especialidade: " + this.especilidade);
        if (seminarios == null) return;
        System.out.print("Seminários ministrados: ");
        for (Seminario seminario : seminarios) {
            System.out.print(seminario.getTitulo() + " | ");
        }
        System.out.println();
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEspecilidade() {
        return especilidade;
    }

    public void setEspecilidade(String especilidade) {
        this.especilidade = especilidade;
    }

    public Seminario[] getSeminarios() {
        return seminarios;
    }

    public void setSeminarios(Seminario[] seminarios) {
        this.seminarios = seminarios;
    }

}
