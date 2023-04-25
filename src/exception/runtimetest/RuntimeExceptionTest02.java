package exception.runtimetest;

public class RuntimeExceptionTest02 {
    public static void main(String[] args) {
        System.out.println("Abcde veja que o codigo é rodado até aqui, depois acontece uma RuntimeException");
        divisao(1, 0);

        System.out.println("Aqui nao aparece");
    }

    private static int divisao(int a, int b) throws IllegalArgumentException{ //Vc esta avisando quem usar seu metodo que existe a possibilidade de acontecer uma exception desse tipo. Opcional em runtimes
        if (b == 0){                                                                //Quando é do tipo checked é obrigatorio esse aviso na assinatura do método.
            throw new IllegalArgumentException("Argumento inválido, nao pode ser 0");
        }
        return a/b;
        // try{              //Essa é uma forma de resolver, mas a de cima é mais simples.
        //     return a/b;
        // } catch (RuntimeException e){ //Vc pode usar o runtimeexception em vez do arithmeticexception pois o runtime é a superclasse de arithmeticexception
        //     e.printStackTrace();
        // } return 0; //Vc coloca esse return para ele parar o codigo depois da exception, pois se nao ele continua depois do problema.
    }
}
