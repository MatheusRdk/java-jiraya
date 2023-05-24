package generics.test;

import java.util.ArrayList;
import java.util.List;

public class GenericsTest01 {
    public static void main(String[] args) { //Generics foram criados para forçar em tempo de compilação os usuários a definir um tipo pras listas
                                             //Só que, em tempo de compilação é que acontece isso, na JVM o java enxerga somente List list = new ArrayList<>(). Isso se chama TypeErasure
        List<String> list = new ArrayList<>(); //A parte do <String> é o generic
        list.add("Abobrinha");
        list.add("Tabletes fininhos");
        System.out.println(list);

    }
}
