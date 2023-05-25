package academy.introducao;

public class Condicionais {
    public static void main(String[] args) {
//         int idade = 15;
//         boolean isAutorizadoBebida = idade >= 18;
//         if(isAutorizadoBebida) {
//             System.out.println("Autorizado a comprar bebida");
//         }
//         if(!isAutorizadoBebida) {
//             System.out.println("Proibido");
//         }

//         int animal = 6;
//         boolean isAnimal = animal >= 5;
//         if(isAnimal) {
//             System.out.println("Animar");
//         } else {
//             System.out.println("Nao e animar");
//         }
//         //ternário
//         double salario = 3999;
//         String mensagemDoar = "Posso doar 100 pila pro curso blzz";
//         String mensagemNaoDoar = "Nao posso doar porraaa";
//         String resultado = salario > 4000 ? mensagemDoar : mensagemNaoDoar;
//         System.out.println(resultado);

            //Switch
        //    byte dia = 4;
        //    switch (dia) {
        //     case 1: 
        //         System.out.println("Domingo");
        //         break;
        //     case 2: 
        //         System.out.println("Segunda");
        //         break;
        //     case 3: 
        //         System.out.println("Terça");
        //         break;
        //     case 4: 
        //         System.out.println("Quarta");
        //         break;
        //     case 5: 
        //         System.out.println("Quinta");
        //         break;
        //     case 6: 
        //         System.out.println("Sexta");
        //         break;
        //     case 7: 
        //         System.out.println("Sábado");
        //         break;
        //     default:
        //         System.out.println("Opção inválida");
        //         break;                    
        //    }
        
        // //Estruturas de repetição
        // int count = 0;
        // while (count < 10) {
        //     System.out.println(count);
        //     count++;
        // }

        // int count2 = 0;
        // do {
        //     System.out.println(count2);
        //     count2++;
        // } while (count2 < 13);

        // for (int i = 0; i < 10; i++){
        //     System.out.println("For " + i);
        // }

        //Break
        for (int x = 0; x < 10; x++){
            if (x > 5) {
                break;  //O break para o for inteiro
            }
            System.out.println("For " + x);
        }

        //Continue
        double valorTotal = 30000;
        for (int parcela = (int) valorTotal; parcela >= 1; parcela--) {
            double valorParcela = valorTotal / parcela;
            if (valorParcela < 1000) {
                continue;
            }
            System.out.println("Parcela " + parcela + "R$ " + valorParcela);
        }
     }
 }