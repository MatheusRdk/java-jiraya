package academy.nio.test;

import java.nio.file.Path;
import java.nio.file.Paths;

public class PathTest01 { //Path e paths sao file mais modernos. Path é uma interface e paths tem varios metodos statics
    public static void main(String[] args) {
        Path p1 = Paths.get("C:\\Users\\Lucas\\Desktop\\java-curso\\maratona-java\\src\\arquivo\\file.txt");
        Path p2 = Paths.get("C:\\Users\\Lucas\\Desktop\\java-curso\\maratona-java\\src\\arquivo","file.txt");
        Path p3 = Paths.get("C:", "Users\\Lucas\\Desktop\\java-curso\\maratona-java\\src\\arquivo", "file.txt");   //Vc pode separar por virgulas o caminho e da certo
        Path p4 = Paths.get("C:","Users", "Lucas", "Desktop", "java-curso", "maratona-java", "src", "academy/associacao/arquivo", "file.txt");

        System.out.println(p1.getFileName());
        System.out.println(p2.getFileName());
        System.out.println(p3.getFileName());
        System.out.println(p4.getFileName());
    }
}
