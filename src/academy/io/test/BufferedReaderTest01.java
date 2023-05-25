package academy.io.test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class BufferedReaderTest01 {
    public static void main(String[] args) {   //O bufferedreader é igual o filereader mas é melhor.
        File file = new File("C:\\Users\\Lucas\\Desktop\\java-curso\\maratona-java\\src\\arquivo\\file.txt");
        try(FileReader fr = new FileReader(file);
            BufferedReader br = new BufferedReader(fr)){
            String linha;
            while ((linha = br.readLine()) != null){
                System.out.println(linha);
            }

        } catch (IOException e){
            e.printStackTrace();
        }
    }
}
