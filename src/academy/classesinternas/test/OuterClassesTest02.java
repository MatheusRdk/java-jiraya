package academy.classesinternas.test;

public class OuterClassesTest02 {  //classes internas nao sao mto usadas.
    private String name = "Mene";

    void print(final String param){  //Classes locais sao classes dentro de métodos.
        String lastName = "Brasileiro"; //Vc pode criar atributos aqui no método, mas ele precisa ser final. Essa versao do java sem vc declarar ja torna o atributo final.
        //Final nao pode ser alterada.
        class LocalClass{
            public void printLocal(){
                System.out.println(param);
                System.out.print(name + " " + lastName);
            }
        }
        LocalClass localClass = new LocalClass(); //A unica forma de usar os métodos de classes locais é assim. No método print vc cria a classe e usa o método dela.
        localClass.printLocal();
    }
    public static void main(String[] args) {
        OuterClassesTest02 outerClass = new OuterClassesTest02();
        outerClass.print("Param test");
    }
}
