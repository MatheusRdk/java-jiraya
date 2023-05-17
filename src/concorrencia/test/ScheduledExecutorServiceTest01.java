package concorrencia.test;

import associacao.dominio.Time;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

public class ScheduledExecutorServiceTest01 {
    private static final ScheduledExecutorService executor = Executors.newScheduledThreadPool(1); //Esse Scheduled é bom para executar coisas de tempo em tempo
    private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");

    private static void beeper(){
        Runnable r = () -> {
            System.out.println(LocalTime.now().format(formatter) + " beep");
            try {
                TimeUnit.SECONDS.sleep(2); //Com o scheduleWithFixedDelay, enquanto a thread dorme o executor nao conta o delay. Se for com o scheduleAtFixedRate, esses 2 seg
                //vao ser contados ja la no delay, ou seja, o delay vai ser de 3 seg.
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        };

        //executor.schedule(r, 5, TimeUnit.SECONDS); //Manda um beep depois de 5 seg de iniciado
        ScheduledFuture<?> scheduledFuture = executor.scheduleWithFixedDelay(r, 1, 5, TimeUnit.SECONDS);//Com esse, vc espera 1 seg pra começar, ai de 5 em 5 ele vai executar o r.
        //Agora, se vc usar scheduleAtFixedRate, aquele sleep la de cima vai contar aqui no delay, ou seja, enquanto dormiu por 2 seg la em cima, esse tempo contou aqui no executor.
        executor.schedule(() -> { //Com uma lambda vc cancela o schedule, mas ainda precisa dar shutdown para parar o programa.
            System.out.println("Cancelando o scheduleWithFixedDelay");
            scheduledFuture.cancel(false);
            executor.shutdown();
        }, 25, TimeUnit.SECONDS);
    }

    public static void main(String[] args) {
        System.out.println(LocalTime.now().format(formatter));
        beeper();
    }
}
