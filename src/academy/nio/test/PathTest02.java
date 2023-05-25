package academy.nio.test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

public class PathTest02 {
    public static void main(String[] args) throws IOException {
        Path pastaPath = Paths.get("pasta");
        if (Files.notExists(pastaPath)){
            Path pastaDirectory = Files.createDirectory(pastaPath);
        }
        Path subPastaPath = Paths.get("pasta/subpasta/subsubpasta");
        Path subPastaDirectory = Files.createDirectories(subPastaPath);
        Path filePath = Paths.get(subPastaPath.toString(), "filele.txt");
        if (Files.notExists(filePath)){
            Path filePathCreated = Files.createFile(filePath);  //Arruma a excecao de ja existir o arquivo
        }

        //Renomear
        Path target = Paths.get(filePath.getParent().toString(), "filele_renamed.txt");   //Usa o getParent pra achar as pastas onde esta o filele.
        Files.copy(filePath, target, StandardCopyOption.REPLACE_EXISTING); //Esse ultimo parametro faz ele substituir o arquivo que ja existe com mesmo nome
    }
}
