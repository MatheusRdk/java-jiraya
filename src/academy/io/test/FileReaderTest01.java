package academy.io.test;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class FileReaderTest01 {
    public static void main(String[] args) {
        File file = new File("C:\\Users\\Lucas\\Desktop\\java-curso\\maratona-java\\src\\arquivo\\file.txt");
        try(FileReader fr = new FileReader(file)){
            //char[] in = new char[20];
            //fr.read(in);  o read retorna um inteiro
            //for (char c : in){
            //  System.out.print(c);
            //}
            int i;
            while((i = fr.read()) != -1){   //Enquanto o i que é o fr read for diferente de -1 (que representa o fim do texto), printa o i, so que com cast char se nao vai ter so numeros
                System.out.print((char)i);
            }

        } catch (IOException e){
            e.printStackTrace();
        }
    }
}
