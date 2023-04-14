package heranca.test;

import heranca.dominio.Funcionario;;
                                                                                             // Nova sequencia de inicilização
public class HerancaTest02 {                                                                // 0 - Bloco de inicilização estático da super classe é executado quando a JVM carregar super classe;
    public static void main(String[] args) {                                               // 1 - Bloco de inicilização estático da sub classe é executado quando a JVM carregar classe filha;
        Funcionario funcionario = new Funcionario("Memes", "123.456.612-32");   // 2 - Alocado espaco em memoria pro objeto da super classe;
        funcionario.imprime();                                                        // 3 - Cada atributo da super classe é criado e inicializado com valores default ou o que for passado;
    }                                                                                     // 4 - Bloco de inicializaçao da super classe é executado na ordem em que aparece;
}                                                                                         // 5 - Construtor da super classe é executado;
                                                                                          // 6 - Alocado espaco em memoria pro objeto da subclasse;
                                                                                       // 7 - Cada atributo da subclasse é criado e inicializado com valores default ou o que for passado;
                                                                                        // 8 - Bloco de inicializaçao da subclasse é executado na ordem em que aparece;
                                                                                         // 9 - Construtor da subclasse é executado;
