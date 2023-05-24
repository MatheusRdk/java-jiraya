package polimorfismo.test;

import polimorfismo.repositorio.Repositorio;
import polimorfismo.servico.RepositorioBancoDeDados;

public class RepositorioTeste01 {
    public static void main(String[] args) {
        Repositorio repositorio = new RepositorioBancoDeDados(); //Quando vc usa a referencia como a interface, que e a mais geral, qualquer objeto que vc colocar vai funcionar com o método abstrato
        repositorio.salvar();                                   // criado na interface, e modificado na instancia dela conforme a necessidade de cada um.
    }
}
