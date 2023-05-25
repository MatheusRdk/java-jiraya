package academy.exception.error.teste;
public class StackOverflowTest01 {
    public static void main(String[] args) {
        recursividade();
    }

    public static void recursividade(){   //Erro é um processo que ocorre na JVM, e dificilmente vc vai parar em tempo de execução (tem que encerrar o processo). Erro é subclasse de throwable e nao e uma 
        //                                    exception. 
        recursividade();                 //Nesse caso, o codigo vai gerar um stackoverflow error, que acontece por falta de memoria.
    }
}
