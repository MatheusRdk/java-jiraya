package academy.streams.test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class StreamTest04 { //FlatMap. Vai servir pra vc nao precisar fazer dois loops pra printar todo mundo da lista de listas.

    public static void main(String[] args) {
       List<List<String>> grupoSus = new ArrayList<>();
       List<String> desenvolvedores = List.of("Uilian bilian", "Chapuleslau", "Vinctorio Lacerda");
       List<String> marketing = List.of("Larissa Manoela", "Seiti Chimada", "Kanabe Hozaru");
       List<String> relacoesInternacionais = List.of("Sushi Kimata", "Felipe Kaolho", "Pepe Juanzito");
       grupoSus.add(desenvolvedores);
       grupoSus.add(marketing);
       grupoSus.add(relacoesInternacionais);

       grupoSus.stream().flatMap(Collection::stream).forEach(System.out::println); //O flatmap entra nas camadas mais profundas da lista e deixa tudo "no mesmo nivel"
    }
}
