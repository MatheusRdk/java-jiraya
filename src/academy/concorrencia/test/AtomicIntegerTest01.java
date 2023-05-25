package academy.concorrencia.test;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

//Variaveis atomicas e lock
class Counter{
    private int count;
    private AtomicInteger atomicInteger = new AtomicInteger();
    private Lock lock = new ReentrantLock(true);
    public AtomicInteger getAtomicInteger() {
        return atomicInteger;
    }

    public int getCount() {
        return count;
    }

    void increment(){
        lock.lock();  //Vc esta usando o lock manualmente assim (lock é quando a thread esta em uma tarefa e precisa terminar ela inteira ate passar pra outra)
        //Usando o lock assim é quase que a mesma coisa que usar um synchronized.
        try{
            count++;
            atomicInteger.incrementAndGet();
        } finally {
            lock.unlock();//Vc precisa tirar o lock dessa forma. O finally garante que vai ser tirado independente se der alguma excessão ou nao.
        }
    }
}

public class AtomicIntegerTest01 {
    public static void main(String[] args) throws InterruptedException {
        Counter counter = new Counter();
        Runnable r = () -> {
            for (int i = 0; i < 10000; i++){
                counter.increment();
            }
        };
        Thread t1 = new Thread(r);
        Thread t2 = new Thread(r);
        t1.start();
        t2.start();
        t1.join();
        t2.join();
        System.out.println(counter.getCount()); //Perceba que a soma da diferente de 20000. Isso acontece pela falta do synchronized. Porem, n vamos usar agora pq afeta a performance.
        //Com o lock, a contagem é certa tambem.
        System.out.println(counter.getAtomicInteger()); //Variaveis Atomicas: Com atomicInteger (tem outros tambem), sem usar o synchronized ele entende que deve adicionar no mesmo.
    }
}
