package optional.test;

import javax.lang.model.element.Name;
import java.util.List;
import java.util.Optional;

public class OptionalTest01 { //Foi feito para evitar o null pointer exception. Ele é um objeto que encapsula outros objetos. Optional n e indicado pra ser usado como atributo, so
    // e indicado pra aparecer no retorno dos métodos.
    public static void main(String[] args) {
        Optional<String> o1 = Optional.of("SEU TOLO!!!! Voce me conhece apenasss como o doooooouauauauau");
        //Optional o2 = Optional.of(null); java.util.Objects.requireNonNull. Optional requer algo nao nulo.
        Optional<String> o3 = Optional.ofNullable(null); //Assim ele imprime um optional vazio. Ou vc pode criar direto um Optional.empty();
        System.out.println(o1);
        System.out.println(o3);
        String name = "matheus";
        System.out.println(findName(name));
        System.out.println("--------------------------------------");

        Optional<String> nameOptional = findName("Matheus"); //Vc usa pra tratar a null pointer exception. Perceba que ele retorna um optional.empty ao inves
        System.out.println(nameOptional);                                        // de uma exceção.
        String empty = nameOptional.orElse("EMPTY"); //Aqui vc define o que ele retorna quando nao encontra. Vc pode usar somente esse pra printar, se tiver ele mostra o nome e
        System.out.println(empty);                       // se nao ele mostra o que vc definir.

        nameOptional.ifPresent(s -> System.out.println(s.toUpperCase())); //O ifPresent recebe um Consumer, vc pode fazer uma lambda pra definir o que fazer se achar o nome.
    }

//    private static String findName(String name) {
//        List<String> list = List.of("Matheus","Suehtam");
//        int i = list.indexOf(name);
//        if(i != -1){
//            return list.get(i);
//        }
//        return null;
//    }

    private static Optional<String> findName(String name) { //Conforme a oracle, essa seria a forma de escrever um metodo optional.
        List<String> list = List.of("Matheus","Suehtam");
        int i = list.indexOf(name);
        if(i != -1){
            return Optional.of(list.get(i));
        }
        return Optional.empty();
    }
}
