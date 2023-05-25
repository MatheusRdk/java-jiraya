package academy.associacao.test;

import java.util.Scanner;

public class LeituraDoTecladoTest01 {
    public static void main(String[] args) {
        try (Scanner entrada = new Scanner(System.in)) {
            System.out.println("Digite seu nome AGORA!!!");
            String nome = entrada.nextLine();
            System.out.println("Qual sua idade??????");
            int idade = entrada.nextInt();
            System.out.println("Digite M ou F para seu sexo??");
            char sexo = entrada.next().charAt(0); //Essa e a forma de conseguir um char com esse next.
            System.out.println("-------------- Vc é: ---------------");
            System.out.println("Nome: " + nome);
            System.out.println("Idade: " + idade);
            System.out.println("Sexo: " + sexo);
        }
    }
}