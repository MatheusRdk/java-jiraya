package academy.nio.test;

import java.nio.file.Path;
import java.nio.file.Paths;

public class NormalizeTest01 {
    public static void main(String[] args) {
        String diretorioProjeto = "home/matheus/dev";
        String arquivoTxt = "../../arquivo.txt";
        Path path1 = Paths.get(diretorioProjeto, arquivoTxt);
        System.out.println(path1); //Perceba que o caminho nao entendeu os pontos como voltar um diretorio, pq nao esta normalizado
        System.out.println(path1.normalize()); //Dessa forma ele mostra certo
        Path path2 = Paths.get("/home/./matheus/./dev/");
        System.out.println(path2);
        System.out.println(path2.normalize());

    }
}
