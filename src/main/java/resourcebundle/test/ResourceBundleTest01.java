package main.java.resourcebundle.test;

import java.util.Locale;
import java.util.ResourceBundle;

public class ResourceBundleTest01 {  //O resourcebundle vai mostrar o que o valor da chave que vc colocou, dependendo de onde esta o locale do bundle.
    public static void main(String[] args) {
        System.out.println(Locale.getDefault());
        ResourceBundle bundle = ResourceBundle.getBundle("messages", new Locale("pt", "BR"));
        System.out.println(bundle.getString("hello"));
        System.out.println(bundle.getString("good.morning"));
        System.out.println(bundle.getString("hi"));
        bundle = ResourceBundle.getBundle("messages", new Locale("en", "US")); //Aqui o usuário troca o idioma pra en.
        System.out.println(bundle.getString("hello"));
        System.out.println(bundle.getString("good.morning"));

        //Sequencia de tentativa de achar arquivo properties pelo java:
        //Locale("fr", "CA");
        //messages_fr_CA.properties
        //messages_fr.properties           Ele primeiro procura o que vc passou, depois só a linguagem, depois em ingles US e só en, e por ultimo um arquivo base
        //messages_en_US.properties
        //messages_en.properties
        //messages.properties  Se ele nao acha aqui, ai lança uma excessão

        System.out.println(bundle.getString("hi"));  //Perceba que mesmo se colocar esse hi antes de definir a linguagem, ele acha ele mesmo assim.




    }
}
