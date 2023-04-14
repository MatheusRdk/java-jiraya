package dominio;

public class Calculadora {
    public void somaDoisNumeros() { //O void é usado pra dizer que o método nao retorna nada, ele tem apenas uma saída.
        System.out.println(10 + 10);
    }

    public void subtraiDoisNumeros() {
        System.out.println(22 - 7);
    }

    public void multiplicaDoisNumeros(int num1, int num2) {
        System.out.println(num1 * num2);

    }

    public double divideDoisNumeros(int num1, int num2) {
        if (num2 == 0) {
            return 0; //Esse método tem retorno
        }
        return num1/num2;
    }

    public void imprimeDivisao(int num1, int num2) {
        if (num2 == 0) {
            System.out.println("Não funfa divisão por ZERO");
            return; //Essa e a forma de usar return com void, dessa forma o codigo para e não avança pra próxima linha.
        } 
        System.out.println(num1/num2);
    }

    public void alteraDoisNumeros(int numero1, int numero2) {
        numero1 = 99;
        numero2 = 54;
        System.out.println("Dentro do altera dois numeros: ");
        System.out.println("num1 "+numero1);
        System.out.println("num2 "+numero2);
    }

    public void somaTodos(int [] numeros) {
        int soma = 0;
        for (int i : numeros) {
            soma += i;
        }
        System.out.println(soma);
    }

    public void somaVarArgs(int... numeros) { //Quando usa o varargs, não pode vir mais nada depois, se for ter outros atributos, tem que ser antes. Verificar como ele está usando o que foi passado.
        int soma = 0;
        for (int i : numeros) {
            soma += i;
        }
        System.out.println(soma);
    }
}
