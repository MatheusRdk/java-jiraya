package academy.regex.test;

import java.util.Scanner;

public class ScannerTest02 {    //Dessa forma com o scanner conseguimos pegar e ja colocar o valor em uma referencia do tipo que ela tem que ser.
    public static void main(String[] args) {   //Token é o valor capturado, e delimitador é o delimitador.
        String texto = "Levi, Eren, Mikasa, 200, true";
        Scanner scanner = new Scanner(texto);
        scanner.useDelimiter(", ");
        while(scanner.hasNext()) {
            if(scanner.hasNextInt()){
                int i = scanner.nextInt();
                System.out.println("Int " + i);
            } else if (scanner.hasNextBoolean()) {
                boolean b = scanner.nextBoolean();
                System.out.println("boolean " + b);
            } else{
                System.out.println(scanner.next());
        }
    }
    }
}
