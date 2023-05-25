package academy.concorrencia.test;

import java.util.concurrent.*;

public class FutureTest01 { //Requisição Assíncrona
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        Future<Double> dollarRequest = executorService.submit(() -> {
            TimeUnit.SECONDS.sleep(3);
            return 4.35D;
        });
        System.out.println(doSomething());
        Double dollarResponse = null; //Na programação assincrona, as threads fazem diferentes tarefas ao mesmo tempo, sempre colo esse timeout
        try {
            dollarResponse = dollarRequest.get(3, TimeUnit.SECONDS);
        } catch (InterruptedException | ExecutionException | TimeoutException e) {
            e.printStackTrace();
        } finally {
            executorService.shutdown(); //Quando trabalha com executor tem q dar um shutdown pra nao travar o programa inteiro.
        }
        System.out.println("Dollar : " + dollarResponse);
    }

    public static long doSomething(){
        System.out.println(Thread.currentThread().getName());
        long sum = 0;
        for (int i = 0; i < 1000000; i++) {
            sum +=i;
        }
        return sum;
    }
}
