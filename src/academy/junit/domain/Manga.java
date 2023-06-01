package academy.junit.domain;

import java.util.Objects;

public record Manga(String name, int episodes) { //Uma classe record é classe como a anotação Value do lombok. Ela gera os acessors(get) dessa classe, e vc passa os atributos dessa forma.
    //Vc nao pode criar atributos diretamente. Somente estáticos. Vale pra bloco de inicialização tambem. É uma classe final, imutavel, nao pode ser alterada, so acessada.

    public Manga {//Esse e o construtor compacto. Tem a opção do canonical tambem, que é praticamente a mesma coisa do que ja foi declarado na linha 5.
        Objects.requireNonNull(name);
    }
}
