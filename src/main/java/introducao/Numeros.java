package introducao;

public class Numeros {
    public static void main(String[] args) {
    //Operadores 
        int numero01 = 10;
        double numero02 = 20;
        double resultado = numero01 / numero02;
        //Para o resultado sair em float/double, um dos numeros tem que ser desses tipos, ou é possível
        //fazer um casting, mas não é o correto.
        double resultado02 = numero01 / (double) numero02;
        System.out.println(resultado02 + " , " + resultado);

        //%
        int resto = 21 % 7;
        System.out.println(resto);

        //< >
        boolean isDezMaiorQueVinte = 10 > 20;
        boolean isDezDiferenteDeOnze = 10 != 11.00;
        System.out.println("isDezMaiorQueVinte? " + isDezMaiorQueVinte);
        System.out.println("isDezDiferenteDeDez? " + isDezDiferenteDeOnze );

        // && (And), || (Or)
        int idade = 35;
        float salario = 3500F; //quando o método pedir um float, coloca 3.6F, pois sem o F ele interpreta como double.
        boolean isDentroDaLei = idade > 30 && salario >= 4612;
        System.out.println("Está dentro da lei de salário mínimo da holanda para imigrantes? " + isDentroDaLei);
        double valorTotalContaCorrente = 200;
        double valorTotalContaPoupança = 10000;
        boolean isPlay5Comprável = valorTotalContaCorrente > 5000 || valorTotalContaPoupança > 5000;
        System.out.println("Da pra comprar esse negócio? "+ isPlay5Comprável);

        //= += -= /= %=
        double bonus = 1700;
        bonus = 2000;
        bonus += 500; //2500
        bonus*= 2; //5000
        bonus++; //5001
        bonus--; //5000
        ++bonus; //quando coloca antes ele faz a soma antes de executar qualquer outra ação,
        //se coloca depois, primeiro ele executa depois soma, como em um print por ex:
        //sout(bonus++) vai printar primeiro, e depois adicionar. O novo valor so vem depois.
        System.out.println(bonus);

    }
    
}
