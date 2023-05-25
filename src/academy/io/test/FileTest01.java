package academy.io.test;

import java.io.File;
import java.io.IOException;
import java.util.Date;

public class FileTest01 {
    public static void main(String[] args) {
        File file = new File("C:\\Users\\Lucas\\Desktop\\java-curso\\maratona-java\\src\\arquivo\\file.txt");
        try {
            //boolean isDeleted = file.delete();     //Para deletar. Porem, como boa pratica vc verifica se o file existe antes de deletar, da forma a seguir
            //System.out.println(isDeleted);
            boolean isCreated = file.createNewFile();
            System.out.println("Created: " + isCreated);  //Se vc executar de novo o createNewFile NAO sobreescreve o arquivo ja criado
            System.out.println(file.getAbsolutePath());
            System.out.println(file.getPath());
            System.out.println(file.isDirectory());
            System.out.println(file.isFile());
            System.out.println(file.isHidden());
            System.out.println("Last modified: " + new Date(file.lastModified()));   //Retorna um long e vc transforma em data


            boolean exists = file.exists();  //verifica se existe antes de deletar
            if (exists) {
                System.out.println("Deleted: " + file.delete());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
