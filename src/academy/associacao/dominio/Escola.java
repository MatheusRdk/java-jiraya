package academy.associacao.dominio;
public class Escola {
    private String nome;
    private Professor[] professores;
    
    public void imprime(){
        System.out.println(this.nome);
        if (professores == null) {
            return;
        }
        for (Professor professo : professores){
            System.out.println(professo.getNome());
        }
    }
    public Escola(String nome) {
        this.nome = nome;
    }


    public String getNome() {
        return nome;
    }


    public void setNome(String nome) {
        this.nome = nome;
    }


    public Professor[] getProfessores() {
        return professores;
    }


    public void setProfessores(Professor[] professores) {
        this.professores = professores;
    }
    
}
