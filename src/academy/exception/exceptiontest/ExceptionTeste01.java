package academy.exception.exceptiontest;

import java.io.File;
import java.io.IOException;

public class ExceptionTeste01 { //Essa é filha direta de exception, ou seja, é checked. Nao deixa compilar, precisa ser tratada.
    public static void main(String[] args) {
        criarNovoArquivo();
    }

    private static void criarNovoArquivo(){
        File file = new File("arquivo\\teste.txt"); //Esse caminho é uma pasta com permissões de criaçao de arquivo negadas. 
        try { //Primeiro ele tenta criar o arquivo. Retorna o isCriado True se der certo. Depois ele da um catch (IOException, que vem do throw IOException do metodo createNewFile. --Entre no metodo
            // para ler ele segurando ctrl--)
            boolean isCriado = file.createNewFile();
            System.out.println("Arquivo criado: " + isCriado);
        } catch (IOException e) { //Vc esta criando um objeto, com a variavel de referencia do tipo IOException e. Vc coloca aqui o tipo de exceçao que vc tenta capturar, sendo o quanto mais específico puder
            //NUNCA DEIXE O BLOCO CATCH EM BRANCO, SEMPRE AVISE O QUE ACONTECEU. Nao coloque logica de negócio no catch, ele serve só para lidar com exception
            e.printStackTrace(); //Esse stacktrace vai mostrar o caminho que o codigo fez pra chegar no erro, de baixo pra cima.
        }
    }
}