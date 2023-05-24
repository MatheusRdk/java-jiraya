package colecoes.test;

import java.util.HashMap;
import java.util.Map;

public class MapTest01 {
    public static void main(String[] args) { //Map trabalha com chave e valor
        Map<String, String> map = new HashMap<>(); //Como é um HASHmap ele sorta por hash e nao permite duplicados.
        map.put("vc", "você");
        map.put("tekladoi", "teclado");
        map.put("mouzze", "mouse");
        map.put("vincent", "Vicente");
        map.putIfAbsent("vc", "você2"); //Coloca se nao existir. Se vc colocar só put ele substitui, se for a mesma chave troca o valor. Se for key diferente e valor igual Ok.
        System.out.println(map);  //Se vc quiser manter a ordem da inserção usa LinkedHashMap.
        System.out.println("--------------------");
        //Para pegar chaves e valores
        for (String key : map.keySet()) {
            System.out.println("Key: " + key + " Valor: " + map.get(key)); //E já pega o valor baseado na key com o .get
        }

        System.out.println("--------------------");

        for (String value : map.values()) {
            System.out.println("Valor: " + value);  //Vc consegue pegar o valor também. Porém, nao consegue pegar a chave a partir do valor, pois um valor pode ter várias chaves.
        }

        System.out.println("--------------------");

        for(Map.Entry<String, String> entry:map.entrySet()){
            System.out.println(entry.getKey() + "-" + entry.getValue()); //Outra forma de ter acesso a chave e o valor no mesmo loop.
        }
    }
}
