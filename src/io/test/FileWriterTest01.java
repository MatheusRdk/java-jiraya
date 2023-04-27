package io.test;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class FileWriterTest01 {
    public static void main(String[] args) {
        File file = new File("C:\\Users\\Lucas\\Desktop\\java-curso\\maratona-java\\src\\arquivo\\file.txt");
        try (FileWriter fw = new FileWriter(file, true)){   //Vc usa o construtor sobrecarregado com o append pra por true pra ele nao criar um novo arquivo, so ir adc linhas
            fw.write("mmmeeemes\nboa fera");
            fw.flush();
            //fw.close();    Vc nao precisa fechar dessa forma quando o tipo do objeto é parente de closeable. Vc so faz o try with resources
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
