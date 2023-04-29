package nio.test;

import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class ZipOutPutStreamTest01 {   //Zipando um arquivo
    public static void main(String[] args) {
        Path arquivozip = Paths.get("pasta/arquivo.zip");   //Caminho onde ficara o zip
        Path arquivosParaZipar = Paths.get("pasta/subpasta1/subsubpasta1");   //Pasta onde estao os arquivos que serao zipados
        zip(arquivozip, arquivosParaZipar);
    }

    private static void zip(Path arquivoZip, Path arquivosParaZipar){
        try(ZipOutputStream zipStream = new ZipOutputStream(Files.newOutputStream(arquivoZip));  //Aqui no try vc cria um outputstream, e um directorystream que vai navegar nos arquivos
            DirectoryStream<Path> directoryStream = Files.newDirectoryStream(arquivosParaZipar)){
            for(Path file:directoryStream){  //O directory stream tem um path para cada arquivo dentro do caminho q vc passou nele
                ZipEntry zipEntry = new ZipEntry(file.getFileName().toString());
                zipStream.putNextEntry(zipEntry);  //zipStream é o zip, pegando e colocando a proxima entrada(zipEntry que é cada arquivo que o directoryStream pegou)
                Files.copy(file, zipStream); //Copiando o conteudo do arquivo pro zipStream. Se nao fizer isso o arquivo nao tem conteudo.
                zipStream.closeEntry();
            }
            System.out.println("Arquivo criado com sucesso!");
        } catch (IOException e){
            e.printStackTrace();
        }
    }
}
