package academy.nio.test;

import java.nio.file.*;

public class PathMatcherTest01 {
    public static void main(String[] args) {
        Path path1 = Paths.get("pasta/subpasta/file.bkp");
        Path path2 = Paths.get("pasta/subpasta/file.txt");
        Path path3 = Paths.get("pasta/subpasta/file.java");
        matches(path1, "glob:*.bkp");   //Se for só 1 *, ele nao considera diretorios. Pra ele considerar qualquer coisa até diretorios usa **
        matches(path1, "glob:**/*.bkp");              //o * quer dizer qualquer coisa, oq importar e ter o .bkp
        matches(path1, "glob:**/*.{bkp,txt,java}");  //Aqui é qualquer coisa que seja igual dentro das chaves
        matches(path2, "glob:**/*.{bkp,txt,java}");
        matches(path3, "glob:**/*.{bkp,txt,java}");
        matches(path1, "glob:**/*.???"); //Qualquer coisa com 3 letras depois do ponto
        matches(path2, "glob:**/*.???");
        matches(path3, "glob:**/*.???");
        matches(path3, "glob:**/file.???");
    }

    private static void matches(Path path, String glob){
        PathMatcher matcher = FileSystems.getDefault().getPathMatcher(glob);
        System.out.println(glob + ": " + matcher.matches(path));
    }
}
