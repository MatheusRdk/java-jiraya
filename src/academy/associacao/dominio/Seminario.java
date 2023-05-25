package academy.associacao.dominio;

public class Seminario {
    private String titulo;
    private Aluno[] aluno;
    private Local local;

    public Seminario(String titulo, Local local) {
        this.titulo = titulo;
        this.local = local;
    }

    public Seminario(String titulo, Aluno[] aluno, Local local) {
        this(titulo, local);
        this.aluno = aluno;
    }


    public void imprime(){
        System.out.println("**************");
        System.out.println("Nome do seminário: " + this.titulo);
        if (local == null) return;
        if (aluno == null){
            System.out.println("Alunos no seminário: Semiário sem alunos cadastrados. buááá");
        } else {
            System.out.print("Alunos no seminário: ");
            for (Aluno alunos : aluno) {
                System.out.print(alunos.getNome() + ", ");
             }
             System.out.println();
        }
        System.out.println("Local do seminário: " + local.getEndereco());
    }



    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public Aluno[] getAluno() {
        return aluno;
    }

    public void setAluno(Aluno[] aluno) {
        this.aluno = aluno;
    }

    public Local getLocal() {
        return local;
    }

    public void setLocal(Local local) {
        this.local = local;
    }

}
