package academy.generics.test;

abstract class Animal{
    public abstract void consulta();

}

class Cachorro extends Animal {
    @Override
    public void consulta() {
        System.out.println("consultando doguinio.....");
    }
}

class Gato extends Animal {
    @Override
    public void consulta() {
        System.out.println("consultando gato.....");
    }
}

public class WildcardTest01 {
    public static void main(String[] args) {
        Cachorro[] cachorros = {new Cachorro(), new Cachorro()};
        Gato[] gatos = {new Gato(), new Gato()};
        printConsulta(cachorros);
        printConsulta(gatos);
        Animal[] animals = {new Gato(), new Cachorro()};
        printConsulta(animals);  //Perceba que dá certo por conta do polimorfismo, o printConsulta recebe animais.
        //Nao daria certo se no fim do printConsulta vc fizesse um animais[1] = new Gato(), pq quando o loop tiver no cachorro o array dele nao pode receber gatos.
    }

    private static void printConsulta(Animal[] animais){
        for (Animal animal : animais){
            animal.consulta();
        }
    }
}
