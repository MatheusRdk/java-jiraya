package colecoes.dominio;

import java.util.Objects;

public class Manga {
    private Long id;
    private String nome;
    private double preco;

    public Manga(Long id, String nome, double preco) {
        Objects.requireNonNull(nome, "Nome não pode ser nulo"); //Joga uma excessão caso esses forem nulos. Pode colocar ou não uma mensagem.
        Objects.requireNonNull(id,"Id não pode ser nulo");
        this.id = id;
        this.nome = nome;
        this.preco = preco;
    }

    //-------------------------O IntelliJ tem uma forma de criar o equals e o hashCode já implementada------------------------------------

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Manga manga = (Manga) o;
        return Double.compare(manga.preco, preco) == 0 && Objects.equals(id, manga.id) && Objects.equals(nome, manga.nome);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nome, preco);
    }
    //------------------------------------------------------------------------------------------------------------------------------------

    @Override
    public String toString() {
        return "Manga{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", preco=" + preco +
                '}';
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
}
