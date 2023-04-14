package interfaces.test;

import interfaces.dominio.DataLoader;
import interfaces.dominio.DatabaseLoader;
import interfaces.dominio.FileLoader;

public class DataLoaderTest01 {
    public static void main(String[] args) {
        DatabaseLoader databaseLoader = new DatabaseLoader();
        FileLoader fileLoader = new FileLoader();
        databaseLoader.load();
        fileLoader.load();

        databaseLoader.remove();
        fileLoader.remove();

        databaseLoader.chekingPermissions();
        fileLoader.chekingPermissions();
                
        DatabaseLoader.retrieveMaxDataSize(); //Metodo estatico de cada CLASSE e interface, nao do objeto.
        DataLoader.retrieveMaxDataSize();
    }
}
