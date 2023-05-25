package academy.colecoes.test;

import java.util.ArrayList;
import java.util.List;

public class ListTest01 {
    public static void main(String[] args) {
//        List nomes = new ArrayList();  //Essa era a forma que usavam até o java 1.4. Vc colocava objetos variados.
//        nomes.add("Matheus");
//        nomes.add("Rudek");
//        nomes.add("Mr Roboto");
//        nomes.add(123124);
//        for (Object nome : nomes) { //Por isso cada um dentro do nomes é um objeto.
//            System.out.println(nome);
//        }

        List<String> nomes = new ArrayList<>();  //A partir do 1.5, vc usa ess diamond e define o que será esta lista. Isso é só em tempo de compilação, para ele te forçar e usar um tipo
        nomes.add("Matheus");                   //Vc nao pode criar uma lista de um tipo primitivo (int, double, char), tem que ser um objeto, ai usa um wrapper.
        nomes.add("Rudek");
        nomes.add("Mr Roboto");
        nomes.remove("Mr Roboto"); //o remove pode passar o objeto(que vai usar o equals para ver se tem algum igual) ou um index.
        //nomes.add(123124); //Perceba que aqui é um erro e nao deixa compilar.
        for (String nome : nomes) { //Agora que é uma String, vc pode usar métodos de string
            System.out.println(nome);
            //nomes.add("DIGIMON DIGITAL"); vc nao pode fazer isso, pois esta alterando o tamanho do nomes dentro do loop que usa ele mesmo.
        }

        System.out.println("------------------------------------------------------------");
        nomes.add("DIGIMON DIGITAL");
        for(int i = 0; i < nomes.size(); i++){ //Agora a forma de descobrir o tamanho é .size()
            System.out.println(nomes.get(i)); //Assim o index é o i, e vc pega pelo index com o .get. Igual se fosse um array e usasse nomes[i] (mas assim é invalido para list).
        }

        System.out.println("------------------------------------------------------------");
        List<Integer> numeros = new ArrayList<>();
        numeros.add(1);
        numeros.add(2);
        numeros.add(5);
        System.out.println(numeros);

        System.out.println("------------------------------------------------------------");
        List<String> nomes2 = new ArrayList<>();
        nomes2.add("Memes");
        nomes2.add("memeiros");
        nomes2.addAll(nomes); //Adicionar todos os elementos de uma outra coleçao de strings (tem que ser do mesmo tipo)
        System.out.println(nomes2);


    }
}
