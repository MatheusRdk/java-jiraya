package academy.io.test;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class BufferedWriterTest01 {
    public static void main(String[] args) {  //O bufferedwriter encapsula o filewriter, e tem uma performance melhor
        File file = new File("C:\\Users\\Lucas\\Desktop\\java-curso\\maratona-java\\src\\arquivo\\file.txt");
        try (FileWriter fw = new FileWriter(file, true);
                BufferedWriter bw = new BufferedWriter(fw)){
            bw.write("memes");
            bw.newLine();                      //     melhor pular linha assim pois nem todo sistema operacional reconhece \n
            bw.flush();
            //bw.close();    Vc nao precisa fechar dessa forma quando o tipo do objeto é parente de closeable. Vc so faz o try with resources
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
