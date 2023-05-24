package interfaces.dominio;

public class DatabaseLoader implements DataLoader, DataRemover {    //Para usar uma interface, ao invés de extends usa o IMPLEMENTS

    @Override
    public void load() {
        System.out.println("Carregando dados do banco de dados...");
    }

    @Override
    public void remove() {
        System.out.println("Removendo dados do banco de dados...");
    }

    @Override
    public void chekingPermissions() {
        System.out.println("Checando permissões do banco de dados...");; //Mesmo esse metodo sendo default do dataloader, vc pode sobreescrever ele com o que quiser cada classe.
    }

    public static void retrieveMaxDataSize(){
        System.out.println("Dentro do retrieveMaxDataSize da classe que implementa a interface."); //Veja que o metodo estatico nao pode ser override, vc faz outro com o mesmo nome e sao coisas
    }                                                                                                                 //diferentes uma da outra.

}
