package academy.concorrencia.test;


import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

class Printer implements Runnable{
    private final int num;

    public Printer(int num) {
        this.num = num;
    }

    @Override
    public void run() {
        System.out.printf("%s inicio: %d%n", Thread.currentThread().getName(), num);
        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.printf("%s finalizou%n", Thread.currentThread().getName());

    }

}
public class ExecutorsTest01 {
    public static void main(String[] args) { //O executors é tipo um framework pra permitir vc controlar um pouco mais o uso das threads.
        ExecutorService executorService = Executors.newFixedThreadPool(4); //Aqui vc definiu que so quer usar 4. Porem, quando vc starta mais de 4 com o execute,
        executorService.execute(new Printer(1));                              //as duas primeiras que terminarem o trabalho, ja vao para o proximo trabalho que tiver.
        executorService.execute(new Printer(2));                             //Ou seja, sempre serao 4 threads nesse caso. Isso é bom se vc estiver trabalhando em algo escalável,
        executorService.execute(new Printer(3));                            //como algo com milhares de usuários, para nao ficarem sendo usadas todas as threads possíveis, e vc
        executorService.execute(new Printer(4));                           //limitar o uso delas.
        executorService.execute(new Printer(5));
        executorService.execute(new Printer(6));
        executorService.shutdown(); //Assim vc "desliga" as threads, mas só quando for finalizado todos os processos.

        ExecutorService executorService2 = Executors.newSingleThreadExecutor(); //Com um singleThreadExecutor só tera uma thread fazendo todas as tarefas.
        ExecutorService executorService3 = Executors.newCachedThreadPool();//Essa cria threads conforme o necessário e reutiliza as que ja tiverem terminado seu trabalho.
    }
}
