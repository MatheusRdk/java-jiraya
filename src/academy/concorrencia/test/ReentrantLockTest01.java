package academy.concorrencia.test;

import java.util.concurrent.locks.ReentrantLock;

class Worker implements Runnable{
    private String name;
    private ReentrantLock lock;

    public Worker(String name, ReentrantLock lock) {
        this.name = name;
        this.lock = lock;
    }

    @Override
    public void run() {
        lock.lock();
        try {
            if (lock.isHeldByCurrentThread()){
                System.out.printf("Thread %s entrou em uma seção crítica%n", name ); //Printf é tipo um format, substitui o %s pela string que vem depois da virgula.
            }
            System.out.printf("%d threads esperando na fila%n", lock.getQueueLength()); //Esse metodo retorna um numero de quantas threads estao esperando para adquirir o lock. No printf, pra int é %d e para float
            // é %f. %n pula linha.
            System.out.printf("Thread %s vai esperar 2s%n", name);
            Thread.sleep(2000);
            System.out.printf("Thread %s finalizou a espera%n", name);

        } catch (InterruptedException e){
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }
}
public class ReentrantLockTest01 {
    public static void main(String[] args) {
        ReentrantLock lock = new ReentrantLock(true);//Esse true vai 'tentar' deixar justo a execuçao, tipo a G nao ser sempre a ultima por ser a ultima a ser startada.
        new Thread(new Worker("A", lock)).start();
        new Thread(new Worker("B", lock)).start();
        new Thread(new Worker("C", lock)).start();
        new Thread(new Worker("D", lock)).start();
        new Thread(new Worker("E", lock)).start();
        new Thread(new Worker("F", lock)).start();
        new Thread(new Worker("G", lock)).start();
    }
}
