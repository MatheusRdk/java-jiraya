package introducao;

public class Arrays {
    public static void main(String[] args) {
        //Valores padrões para inicialização de variáveis vazias, por exemplo int numero;
        //int, byte, short, long, float, double : 0
        //char: '\u0000' espaço em branco.
        //boolean: false
        //String: null

        // Arrays usam [] depois da classe
        // int [] numeros = new int[20]; //Para criar um array vazio, vc cria um objeto com quantos espaços tem nesse array de inteiros, nesse caso 20. Vc reservou 20 espaços na memória.
        // Se printar desse jeito, aparece o espaço da memória reservado para eles, como [I@4617c264.
        //Você só pode dar new em tipos primitivos que são array.
        // System.out.println(numeros);

        // int [] idade = {2, 55, 70};
        // System.out.println(idade[1]);

        // String [] nomes = new String[3];
        // nomes[0] = "MEME";
        // nomes[1] = "MENE";
        // nomes[2] = "Quené";
        // for (int i = 0; i < 3; i++) {
        //     System.out.println(nomes[i]);
        // }

        // for (int num : idade) { //Para dar certo o tipo do num precisa ser o mesmo dos tipos do array.
        //     System.out.println(num);
        // }

        
        //Array multidimensional
        int [][] dias = new int[3][3];
        dias [0][0] = 31;
        dias [0][1] = 28;
        dias [0][2] = 31;

        dias [1][0] = 31;
        dias [1][1] = 28;
        dias [1][2] = 31;

        for (int i = 0; i < dias.length; i++) {
            for (int j = 0; j < dias[i].length; j++) {
                System.out.println(dias[i][j]);
            };
        }
        System.out.println("---------------------------------");
        
        //Para iterar sobre o array com o foreach
        for(int[] arrBase : dias){
            for(int num : arrBase){
                System.out.println(num + " for each");
            }
        }

        //Você pode criar um array que cada espaço possua uma quantidade de valores diferentes
        int[][] arrayInt = new int[3][];
        arrayInt[0] = new int[3];
        arrayInt[1] = new int[5];
        arrayInt[2] = new int[]{1, 2, 3, 4, 5, 6, 7}; //Forma de inicializar o array com valores. Precisa por o new int quando for multidimensional
        for (int[] i : arrayInt){
            System.out.println("\n---------------------------------");
            for (int j : i){
                System.out.println(j + " ");
            }
        }
        int[][] arrayInt2 = {{0,0,0}, {1,1,1,1}, {2,2,2,2,2}}; //Outra forma de inicializar o array com valores.
        System.out.println("\n---------------------------------");
        System.out.println(arrayInt2[2]);//Printa o espaço na memória
    }  
}
