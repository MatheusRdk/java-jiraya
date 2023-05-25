package academy.concorrencia.test;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;

public class BlockingQueueTest01 {
    public static void main(String[] args) throws InterruptedException {
//        BlockingQueue<String> bq = new ArrayBlockingQueue<>(1);
//        bq.put("Matheus");
//        System.out.printf("%s adicionou o valor %s%n", Thread.currentThread().getName(), bq.peek());
//        System.out.println("Tentando adicionar um novo valor");
//        bq.put("Rudek");                                                    //Dessa forma ele vai ficar esperando abrir espaço para poder colocar o outro valor
//        System.out.printf("%s adicionou o valor %s%n", Thread.currentThread().getName(), bq.peek());

        BlockingQueue<String> bq = new ArrayBlockingQueue<>(1);
        bq.put("Matheus");
        System.out.printf("%s adicionou o valor %s%n", Thread.currentThread().getName(), bq.peek());
        System.out.println("Tentando adicionar um novo valor");
        new Thread(new RemoveFromQueue(bq)).start();
        bq.put("Rudek");
        System.out.printf("%s adicionou o valor %s%n", Thread.currentThread().getName(), bq.peek());
    }

    static class RemoveFromQueue implements Runnable{
        private final BlockingQueue<String> bq;

        public RemoveFromQueue(BlockingQueue<String> bq) {
            this.bq = bq;
        }

        @Override
        public void run() {
            System.out.printf("%s indo dormir por 2s %n", Thread.currentThread().getName());
            try {
                TimeUnit.SECONDS.sleep(2);
                System.out.printf("%s removendo valor da queue %s%n", Thread.currentThread().getName(), bq.take());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
