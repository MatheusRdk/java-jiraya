package test;

import dominio.Calculadora;

public class calculadoraTest02 {
    public static void main(String[] args) {
        Calculadora calculadora = new Calculadora();
        int[] numeros = {1, 2, 3, 4, 5, 6, 7, 8};

        calculadora.somaTodos(numeros);

        calculadora.somaVarArgs(1, 2, 3, 4, 5, 6, 7, 8); //A diferença do varargs é essa, pode passar os números diretamente.
    }
}
