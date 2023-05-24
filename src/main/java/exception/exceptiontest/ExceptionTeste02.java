package exception.exceptiontest;

import java.io.File;
import java.io.IOException;

public class ExceptionTeste02 { 
    public static void main(String[] args) throws IOException {
        criarNovoArquivo();
    }

    public static void criarNovoArquivo() throws IOException{
        File file = new File("arquivo\\teste.txt"); //Nao faz sentido usar o throws exception em um método privado, que somente sera usado por essa classe. É melhor usar um try catch.
        try {                                                 //Vc usa throws em metodos publicos pois podem ser usados por qualquer um.
            boolean isCriado = file.createNewFile();
            System.out.println("Arquivo criado: " + isCriado);
        } catch (IOException e) {
            e.printStackTrace();
            throw e;
        }
    }
}