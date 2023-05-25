package academy.introducaometodos.test;

import academy.introducaometodos.dominio.Estudante;
import academy.introducaometodos.dominio.Imprime;

public class estudanteTest01 {
    public static void main(String[] args) {
        Estudante estudante01 = new Estudante();
        Estudante estudante02 = new Estudante();
        Imprime impressora = new Imprime();

        estudante01.nome = "Middddddle";
        estudante01.idade = 18;
        estudante01.sexo = 'M';

        estudante02.nome = "MMMMMMmmmmmmbombs";
        estudante02.idade = 79;
        estudante02.sexo = 'F';

        impressora.imprime(estudante01); //Quando vc passa o argumento, vc esta colocando a referencia que o estudante01 faz no estudante da classe Imprime.
        impressora.imprime(estudante02);

        impressora.imprime(estudante01); //Se executar novamente, vc ve que o objeto foi alterado pelo método, SE O MÉTODO ESTIVER ALTERANDO ALGUM VALOR.
        impressora.imprime(estudante02);

    }
}
