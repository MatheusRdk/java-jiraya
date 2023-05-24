package streams.test;

import java.util.stream.LongStream;
import java.util.stream.Stream;

public class StreamTest16 {
    public static void main(String[] args) {
        System.out.println(Runtime.getRuntime().availableProcessors()); //Quantas threads um parallel stream vai utilizar de acordo com seu pc.
        long num = 100_000_000;
        sumFor(num);
        sumStreamIterate(num);
        sumParallelStreamIterate(num);
        sumLongStreamIterate(num);
        sumParallelLongStreamIterate(num);
    }

    private static void sumFor(long num){
        System.out.println("Sum for");
        long result = 0;
        long init = System.currentTimeMillis();
        for (long i = 1; i<= num; i++){
            result += i;
        }
        long end = System.currentTimeMillis();
        System.out.println(result + ": " + (end - init) + "ms");
        System.out.println("--------------------");
    }

    private static void sumStreamIterate(long num){
        System.out.println("Sum StreamIterate");
        long result = 0;
        long init = System.currentTimeMillis();
        result = Stream.iterate(1L, i -> i+1).limit(num).reduce(0L, Long::sum);
        long end = System.currentTimeMillis();
        System.out.println(result + ": " + (end - init) + "ms");
        System.out.println("--------------------");
    }

    private static void sumParallelStreamIterate(long num){ //Pra fazer ele executar em multiplas threads, coloca o parallel em qualquer lugar da linha da stream.
        //O calculo paralelo é como se cada uma das threads fizesse uma parte de uma soma que vc mande fazer, dividindo o trabalho.
        //Aqui o resultado parece pior, mas é que uma soma simples nao é algo ideal para usar processamento paralelo.
        System.out.println("Sum ParallelStreamIterate");
        long result = 0;
        long init = System.currentTimeMillis();
        result = Stream.iterate(1L, i -> i+1).limit(num).parallel().reduce(0L, Long::sum);
        long end = System.currentTimeMillis();
        System.out.println(result + ": " + (end - init) + "ms");
        System.out.println("--------------------");
    }

    private static void sumLongStreamIterate(long num){
        System.out.println("Sum LongStreamIterate");
        long result = 0;
        long init = System.currentTimeMillis();
        result = LongStream.rangeClosed(1L, num).reduce(0L, Long::sum);
        long end = System.currentTimeMillis();
        System.out.println(result + ": " + (end - init) + "ms");
        System.out.println("--------------------");
    }

    private static void sumParallelLongStreamIterate(long num){
        System.out.println("Sum sumParallelLongStreamIterate");
        long result = 0;
        long init = System.currentTimeMillis();
        result = LongStream.rangeClosed(1L, num).parallel().reduce(0L, Long::sum);
        long end = System.currentTimeMillis();
        System.out.println(result + ": " + (end - init) + "ms");
        System.out.println("--------------------");
    }

    //Coisas importantes para levar em consideração se vale a pena usar processamento paralelo:
    //-Benchmark - importante fazer pra testar o desempenho e ver se realmente vale a pena.
    //-Unboxing | boxing - afetam muito o desempenho.
    //-limit() e findFirst() nao sao bons com processamento paralelo, mas findAny() é muito bom.
    //-Custo total da computação: Geralmente quanto mais poder de processamento mais vc se beneficia usando multiplas threads.
    //-Quantidade de dados: Se for mto pequena nao adianta usar parallel.
    //-Tipos de coleções: é bom pesquisar antes de usar em determinadas colecoes pra ver se adianta.
    //-Tamanho do stream - stream com tamanho definido sao melhores pra paralelizar, ao contrario de streams geradas.
    //-Processamento merge - O parallel vai divindo as tarefas grandes ate serem pequenas e nao poderem mais ser divididas, ai resolve de pouco em pouco.
}
