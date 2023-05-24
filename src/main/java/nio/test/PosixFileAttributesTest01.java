package nio.test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.PosixFileAttributeView;
import java.nio.file.attribute.PosixFileAttributes;
import java.nio.file.attribute.PosixFilePermission;
import java.nio.file.attribute.PosixFilePermissions;
import java.util.Set;

public class PosixFileAttributesTest01 {
    public static void main(String[] args) throws IOException {                                           //Nao da certo no windows, so estou deixando pra teste
        Path path = Paths.get("/home/lucasrudek/dev/file.txt");
        PosixFileAttributes posixFileAttributes = Files.readAttributes(path, PosixFileAttributes.class);  //Nao vai dar certo pq é pra posix, tem q baixar terminal ubunto e usar.
        System.out.println(posixFileAttributes.permissions());
        PosixFileAttributeView fileAttributeView = Files.getFileAttributeView(path, PosixFileAttributeView.class);
        Set<PosixFilePermission> posixFilePermissions = PosixFilePermissions.fromString("rw-rw-rw-");
        fileAttributeView.setPermissions(posixFilePermissions);
        System.out.println(fileAttributeView.readAttributes().permissions());
    }
}

//Para executar esse codigo no terminal ubuntu:
//lucasrudek@DESKTOP-9AHA0R6:~/dev$ vi PosixFileAttributesTest01.java  aqui dentro vc aperta insert pra escrever, dai esc e digita :x para sair e salvar o arquivo
//lucasrudek@DESKTOP-9AHA0R6:~/dev$ javac PosixFileAttributesTest01.java
//lucasrudek@DESKTOP-9AHA0R6:~/dev$ java PosixFileAttributesTest01
//  output:  [OWNER_WRITE, GROUP_READ, OWNER_READ, OTHERS_READ]

