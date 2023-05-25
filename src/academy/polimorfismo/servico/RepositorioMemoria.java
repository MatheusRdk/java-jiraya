package academy.polimorfismo.servico;

import academy.polimorfismo.repositorio.Repositorio;

public class RepositorioMemoria implements Repositorio {

    @Override
    public void salvar() {
        System.out.println("Salvando em memória...");
    }
    
}
