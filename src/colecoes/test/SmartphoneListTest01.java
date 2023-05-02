package colecoes.test;

import colecoes.dominio.Smartphone;

import java.util.ArrayList;
import java.util.List;

public class SmartphoneListTest01 {
    public static void main(String[] args) {
        Smartphone s1 = new Smartphone("AAVA23", "IPHONE");
        Smartphone s2 = new Smartphone("GAS324", "SAMSUNG");
        Smartphone s3 = new Smartphone("1241SD", "GOOGLE");
        List<Smartphone> smartphones = new ArrayList<>(6);
        smartphones.add(s1);
        smartphones.add(s2);
        smartphones.add(0, s3); //Mudando o índice do s3 que originalmente é 2, que é definido na sequência pelo java.
        //smartphones.clear(); //Deleta todos dentro da arraylist e mantém a variável de referencia.
        for (Smartphone smart : smartphones){
            System.out.println(smart);
        }

        Smartphone s4 = new Smartphone("1241SD", "GOOGLE"); //Digamos que um usuário insira manualmente um valor que já existe
        System.out.println(smartphones.contains(s4)); //Aqui vc confere se já tem um objeto igual dentro. O contains usa o equals dentro dele, e usa aquele que já definimos anteriormente

        int indexOfSmartphone4 = smartphones.indexOf(s4);
        System.out.println(indexOfSmartphone4); //Ele retorna o index do s3 já que são iguais, o indexOf também usa o equals. Se nao existe retorna -1.
        System.out.println(smartphones.get(indexOfSmartphone4)); //Retornando o smartphone pelo index.

        //O equals e hashCode sao sempre usados pelo java para encontrar os objetos. Por isso é tão importante ter eles bem definidos.

    }
}
