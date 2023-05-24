package main.java.threads.test;

public class DeadLockTest01 {
    public static void main(String[] args) {   //Deadlock é quando uma thread esta em um objeto synchronized e a outra tambem, e chega em um ponto que a primeira precisa de algo da
        Object lock1 = new Object();         //segunda, e a segunda precisa de algo da primeira, e os dois ficam esperando eternamente pra poderem entrar no objeto que precisam,
        Object lock2 = new Object();        //pois como sao synchronized ela precisa terminar tudo que tem no run pra outra poder entrar nesse objeto.
        Runnable r1 = () -> {
            synchronized (lock1){
                System.out.println("Thread 1: segurando lock 1");
                System.out.println("Thread 1: esperando lock 2");
                synchronized (lock2){
                    System.out.println("Thread 1: segurando lock 2");
                }
            }
        };
        Runnable r2 = () -> {
            synchronized (lock2){
                System.out.println("Thread 2: segurando lock 2");
                System.out.println("Thread 2: esperando lock 1");
                synchronized (lock1){
                    System.out.println("Thread 2: segurando lock 1");
                }
            }
        };
        new Thread(r1).start();
        new Thread(r2).start();
    }
}
