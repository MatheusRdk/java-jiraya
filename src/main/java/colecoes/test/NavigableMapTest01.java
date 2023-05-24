package colecoes.test;

import colecoes.dominio.Consumidor;

import java.util.Map;
import java.util.NavigableMap;
import java.util.TreeMap;

public class NavigableMapTest01 {
    public static void main(String[] args) {
//        Consumidor consumidor1 = new Consumidor("Matheus");
//        Consumidor consumidor2 = new Consumidor("Empresa do Brasil");
        NavigableMap<String, String> map = new TreeMap<>();   //O treeMap vai ordernar os valores, entao precisa que eles sejam comparáveis.
//        map.put(consumidor1, consumidor1); //Esse da classcastexception, pois consumidor nao implementa comparable
        map.put("C", "Letra C");
        map.put("B", "Letra B");
        map.put("A", "Letra A"); //Esses dao certo por ser string string, que já tem o compareTo do string
        map.put("D", "Letra D");
        for (Map.Entry<String, String> entry : map.entrySet()){
            System.out.println(entry.getKey() + " - " + entry.getValue());
        }
        //O treeMap tem os mesmos métodos que tinha no navigableSet com treeSet (lower, floor, etc.).

        System.out.println(map.headMap("C"));//Método que mostra todos abaixo do C (nesse caso, A e B sao "menores"), na ordem definida. Bom para quando está trabalhando
        //                   com preço. Tomar cuidado pois o headMap está tipo "linkado" com o map. Se vc deletar algo pelo headMap (headMap("X").remove("Y")) ele deleta do map original.
    }                       //Use true depois da key que passou para inlcuir o C junto na lista mostrada.
}
