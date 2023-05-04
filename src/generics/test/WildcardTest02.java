package generics.test;

import java.util.List;

public class WildcardTest02 {
    public static void main(String[] args) {
        List<Cachorro> cachorros = List.of(new Cachorro(), new Cachorro());
        List<Gato> gatos = List.of(new Gato(), new Gato());
        printConsulta(cachorros);
        printConsulta(gatos);

    }
    //Type Erasure: O java não sabe que o que vc está passando é um animal. Quando trabalha com listas, vc teria que passar exatamente o que passou nos parâmetros.

    // - Ai que entra o Wildcard '?'. Vc usa ele dessa forma para especificar que vai aceitar qualquer tipo de lista que extenda animal
    // - Porém, quando vc faz isso assina um contrato, no qual vc nao pode adicionar objetos dentro desse método
    // - O método será somente de leitura.
    // - Vc só pode usar dessa forma o extends, e nao o implements.
    private static void printConsulta(List<? extends Animal> animais){
        for (Animal animal : animais){
            animal.consulta();
            //Aqui vc nao pode adicionar, pois o java nao tem garantias dos irmaos da classe animal. Pq gato nao pode referenciar cachorro e ao contrário também.
        }
    }

    //No de cima, seria Animal e seus filhos
    //Abaixo, seria Cachorro e qualquer coisa acima. Ou seja, Cachorro, Animais, Objects
    private static void printConsultaCachorro(List<? super Cachorro> animais){

    }

    private static void printConsultaAnimais(List<? super Animal> animais){
        animais.add(new Cachorro());
        animais.add(new Gato());
        //Aqui sim, eu posso adicionar. Dessa forma, o java tem garantias de que vao ser passados animais ou objects, entao ele permite.
    }
}
