package academy.colecoes.test;

import academy.colecoes.dominio.Smartphone;

public class EqualsTest01 {
    public static void main(String[] args) {
//        String nome = "Matheus Rudek";
//        String nome2 = new String("Matheus Rudek");
//        System.out.println(nome == nome2);  //Dessa forma ele compara se o valor de referencia é o mesmo, e quando usa o new String ele cria outro.
//        System.out.println(nome.equals(nome2));   //Para comparar se o valor mesmo é igual usa o equals.

//        Smartphone s1 = new Smartphone("1BB2N", "Iphone");
//        Smartphone s2 = new Smartphone("1BB2N", "Iphone");
//        System.out.println(s1.equals(s2)); //False pq cada variavel faz referencia pra um objeto diferente.
//        Smartphone s1 = new Smartphone("1BB2N", "Iphone");
//        Smartphone s2 = s1;  //Para dar True teria que ser dessa forma, pq ai o objeto do s2 seria o mesmo do s1.
//        System.out.println(s1.equals(s2));

       Smartphone s1 = new Smartphone("1BB2N", "Iphone");
       Smartphone s2 = new Smartphone("1BB2N", "Iphone");
       System.out.println(s1.equals(s2)); //Agora sim vai dar true, depois de reescrever o método equals.

        //Porém, tem que levar em consideração o objetivo (regra de negócio). Aqui somente o serial foi usado para ver se era o mesmo, porém, pode ser a marca também, ou que for
        //necessário. Para um smartphone, se o serial fosse igual mas a marca diferente, sao aparelhos diferentes. Ai teria que colocar a marca na lógica do equals também.
    }
}
