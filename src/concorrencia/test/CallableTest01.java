package concorrencia.test;

import java.util.concurrent.*;

class RandomNumberCallable implements Callable<String>{
    @Override
    public String call() throws Exception {
        //Math.random(); //A diferença desse pro ThreadLocalRandom é que esse é sincronizado. Quando trabalha com multiplas threads o ThreadLocalRandom é melhor.
        int count = ThreadLocalRandom.current().nextInt(1, 11);
        for (int i = 0; i < count; i++) {
            System.out.printf("%s executando uma tarefa callable...%n", Thread.currentThread().getName());
        }
        return String.format("%s terminou e o numero aletório é %d%n", Thread.currentThread().getName(), count);
    }
}

public class CallableTest01 {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        RandomNumberCallable randomNumberCallable = new RandomNumberCallable();
        ExecutorService executorService = Executors.newFixedThreadPool(2);
        Future<String> future = executorService.submit(randomNumberCallable);
        String s = future.get(); //O future.get faz a thread main esperar o callable acabar pra continuar o codigo.
        System.out.printf("Program finished %s.", s);
        executorService.shutdown();
    }
}
