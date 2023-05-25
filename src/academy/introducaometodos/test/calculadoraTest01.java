package academy.introducaometodos.test;

import academy.introducaometodos.dominio.Calculadora;

public class calculadoraTest01 {
    public static void main(String[] args) {
        Calculadora calculadora = new Calculadora();

        calculadora.somaDoisNumeros(); //Chamando o método que nao retornou nada, so tem uma saída.
        System.out.println("Finalizado teste soma calculadora");
        System.out.println("\n---------------\n");

        calculadora.subtraiDoisNumeros();
        System.out.println("Finalizado teste subtração calculadora");
        System.out.println("\n---------------\n");

        calculadora.multiplicaDoisNumeros(5, 2);
        System.out.println("Finalizado teste multiplicação calculadora");
        System.out.println("\n---------------\n");

        double resultado = calculadora.divideDoisNumeros(10, 0); //Esse método tem retorno
        System.out.println(resultado);
        System.out.println("Finalizado teste divisão calculadora");
        System.out.println("\n---------------\n");

        calculadora.imprimeDivisao(10, 0); //Esse método tem retorno
        System.out.println("Finalizado teste divisão com void calculadora");
        System.out.println("\n---------------\n");
        
        int numero1 = 20;
        int numero2 = 33;
        calculadora.alteraDoisNumeros(numero1, numero2); //O método usa uma cópia das variáveis, então ela não altera as originais. ISSO quando são variáveis do tipo primitivas
        System.out.println("Fora do altera "+numero1);
        System.out.println("Fora do altera "+numero2);

    }
}
