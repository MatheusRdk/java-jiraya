package interfaces.dominio;

public class FileLoader implements DataLoader, DataRemover { //Voce pode implementar varias interfaces em uma classe, sem limite. Mas precisa usar o override em todos os metodos.

    @Override
    public void load() {
        System.out.println("Carregando dados de um arquivo...");
    }

    @Override
    public void remove() {
        System.out.println("Removendo dados de um arquivo...");
    }

    @Override
    public void chekingPermissions() {
        System.out.println("Checando permissões do arquivo...");; //Mesmo esse metodo sendo default do dataloader, vc pode sobreescrever ele com o que quiser cada classe.
    }
}
