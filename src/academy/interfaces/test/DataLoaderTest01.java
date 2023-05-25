package academy.interfaces.test;

import academy.interfaces.dominio.DataLoader;
import academy.interfaces.dominio.FileLoader;
import academy.interfaces.dominio.DatabaseLoader;

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
