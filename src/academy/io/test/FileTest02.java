package academy.io.test;

import java.io.File;
import java.io.IOException;

public class FileTest02 {
    public static void main(String[] args) throws IOException {  //Criando diretórios
        File diretorio = new File("directoryyy");
        boolean isDiretorioCriado = diretorio.mkdir();
        System.out.println("Diretório criado: " + isDiretorioCriado);
        File fileArquivoDiretorio = new File(diretorio, "arquivo.txt");  //Criando arquivo direto no diretorio criado acima
        boolean isFileCreated = fileArquivoDiretorio.createNewFile();
        System.out.println("Arquivo criado: " + isFileCreated);

        File fileRenamed = new File(diretorio,"renamed_file.txt");   //Renomeando arquivos
        boolean isRenamed = fileArquivoDiretorio.renameTo(fileRenamed);
        System.out.println(isRenamed);

        File directoryRenamed = new File("renamed_directory");
        boolean isDiretorioRenamed = diretorio.renameTo(directoryRenamed);
        System.out.println(isDiretorioRenamed);
    }
}
