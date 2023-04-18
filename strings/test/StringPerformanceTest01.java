package strings.test;

public class StringPerformanceTest01 {
    public static void main(String[] args) {
        long inicio = System.currentTimeMillis();
        concatString(10_000); //Vc pode usar o underline para separar os numeros no java
        long fim = System.currentTimeMillis();
        System.out.println("Tempo gasto pela string: " + (fim - inicio) + "ms");

        long inicio2 = System.currentTimeMillis();   //Usando o método do StringBuilder o tempo diminui muito 
        concatStringBuilder(1000000);                                                                   //No geral vc vai usar string normal. Quando algum dia vc trabalhar com tantas strings
        long fim2 = System.currentTimeMillis();                                                               // e sentir que a performance esta sendo afetada, ai vc pensa em usar o builder e buffer.
        System.out.println("Tempo gasto pela stringbuilder: " + (fim2 - inicio2) + "ms");

        long inicio3 = System.currentTimeMillis();  //String buffer lida com threads.
        concatStringBuffer(1000000);
        long fim3 = System.currentTimeMillis();
        System.out.println("Tempo gasto pela stringbuffer: " + (fim3 - inicio3) + "ms");
    }


    private static void concatString(int tamanho){
        String texto = "";
        for (int i = 0; i < tamanho; i++){
            texto += i; //0, 01, 012, 0123...
        }
        System.out.println(texto.charAt(0));
    }

    private static void concatStringBuilder(int tamanho) {
        StringBuilder sb =  new StringBuilder();
        for (int i = 0; i < tamanho; i++){
            sb.append(i);
        }
    }

    private static void concatStringBuffer(int tamanho) {
        StringBuffer sb =  new StringBuffer();
        for (int i = 0; i < tamanho; i++){
            sb.append(i);
        }
    }
}
