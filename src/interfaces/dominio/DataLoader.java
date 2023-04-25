package interfaces.dominio;

public interface DataLoader { //Uma interface so tem metodos abstratos. 

    //Vc nunca pode reescrever esses metodos de forma mais restritiva nas classes que implementam, sempre igual ou mais aberta. Sequencia de restrição ---> private - default - protected - public

    //TODOS OS ATRIBUTOS EM UMA INTERFACE SAO CONSTANTES.

    public static final int MAX_DATA_SIZE = 10; //o public static final é redundante, pois todos os atributos em interface sao assim.

    public abstract void load();
    //O public e o abstract sao redundantes nas interfaces, vc pode usar só o void load() ou default void chekingPermissions() no nome do metodo se quiser.
    public default void chekingPermissions(){ //Usando default, vc coloca um metodo que nao precisa ser sobreescrito em todas as classes que usarem essa interface.
        System.out.println("Checando permissões......");
    }

    public static void retrieveMaxDataSize(){
        System.out.println("Dentro do retrieveMaxDataSize da interface.");
    }
}      //Metodos default permitem metodos concretos, com funcionalidades...
