package academy.nio.test;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.FileTime;
import java.time.LocalDateTime;
import java.time.ZoneOffset;

public class BasicFileAttributesTest01 {
    public static void main(String[] args) throws IOException {
        //BasicFileAttributes, DosFileAttributes, PosixFileAttributes Cada um desses para um SO

        //Forma antiga de alterar uma data de modificação
        LocalDateTime date = LocalDateTime.now().minusDays(10); //Agora menos 10 dias
        File file = new File("renamed_directory/novo.txt");
        boolean isCreated = file.createNewFile();
        boolean isModified = file.setLastModified(date.toInstant(ZoneOffset.UTC).toEpochMilli()); //Mudar a data de ultima modificaçao
        System.out.println(isModified);


        //Forma nova
        Path path = Paths.get("renamed_directory/novo_path.txt");
        Files.createFile(path);
        FileTime fileTime = FileTime.from(date.toInstant(ZoneOffset.UTC));
        Files.setLastModifiedTime(path, fileTime);
        System.out.println(Files.isExecutable(path));
        System.out.println(Files.isHidden(path));
        System.out.println(Files.isReadable(path));

    }
}
