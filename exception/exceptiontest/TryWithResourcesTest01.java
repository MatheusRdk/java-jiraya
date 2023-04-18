package exception.exceptiontest;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

import exception.dominio.Leitor1;
import exception.dominio.Leitor2;

public class TryWithResourcesTest01 {
    public static void main(String[] args) {
        lerArquivo();
    }



    public static void lerArquivo(){ //Try with resources
        try(Leitor1 leitor1 = new Leitor1(); //Eu posso declarar as variaveis dentro do try, SE o métodos implementem closeable ou autocloseable. Serve pra quando o recurso tem que ser fechado.
        Leitor2 leitor2 = new Leitor2()){   //Perceba que foram executados pelo main de baixo pra cima. Ele inverte a ordem.
                                            // O próprio Java se encarrega de fechar quando os recursos param de ser utilizados.
        } catch (IOException e){
            
        }
    }



    public static void lerArquivo2(){  //CÓDIGO FEIO
        Reader reader = null; //Declara a variável de referencia fora do bloco try para poder ser usada nos outros blocos, como o finally.
        try{
            reader = new BufferedReader(new FileReader("teste.txt"));
            
        } catch (FileNotFoundException e){
            e.printStackTrace();

        } finally{
            try {
                if (reader != null){
                    reader.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
