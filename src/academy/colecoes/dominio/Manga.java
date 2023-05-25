package academy.colecoes.dominio;

import java.util.Objects;

public class Manga implements Comparable<Manga> { //Para dar certo o sort, tem que implementar esse comparable e reescrever o único método que ele tem que é o compareTo
    private Long id;
    private String nome;
    private double preco;
    private int quantidade;

    public Manga(Long id, String nome, double preco) {
        Objects.requireNonNull(nome, "Nome não pode ser nulo"); //Joga uma excessão caso esses forem nulos. Pode colocar ou não uma mensagem.
        Objects.requireNonNull(id,"Id não pode ser nulo");
        this.id = id;
        this.nome = nome;
        this.preco = preco;
    }

    public Manga(Long id, String nome, double preco, int quantidade) {
        this(id, nome, preco);
        this.quantidade = quantidade;
    }

    //-------------------------O IntelliJ tem uma forma de criar o equals e o hashCode já implementada------------------------------------

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Manga manga = (Manga) o;
        return Objects.equals(id, manga.id) && Objects.equals(nome, manga.nome);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nome);
    }


    //------------------------------------------------------------------------------------------------------------------------------------


    @Override
    public String toString() {
        return "Manga{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", preco=" + preco +
                ", quantidade=" + quantidade +
                '}';
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }


    //Regras para implementar o compareTo. Perceba que ele retorna um int.
    //Tem que retornar negativo se o this < outroManga
    //Se this == outroManga, return 0
    //Se this > outroManga, retorna positivo.
    @Override
    public int compareTo(Manga outroManga) {
//        if(this.id < outroManga.getId()){
//            return -1;
//        } else if (this.id.equals(outroManga.getId())){  Todo esse código é reduzido aquele abaixo, devido ao Long ser um wrapper, que já tem o compareTo dele mesmo.
//            return 0;                                   Porém, isso só é possível pq id é de um tipo Wrapper, se for um tipo primitivo (como o preço) ai nao dá boa.
//        } else {                                    Ai vc poderia usar o seguinte para transformar o preço em Long por ex.: Double.valueOf(preco).compare(outroManga.getPreco())
//            return 1;
//        }
        return this.nome.compareTo(outroManga.getNome()); //Perceba que com string dá, pois string tem vários métodos como o compareTo.
        //return this.id.compareTo(outroManga.getId());
    }
}
