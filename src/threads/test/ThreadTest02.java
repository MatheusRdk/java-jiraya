package threads.test;

public class ThreadTest02 {
    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(new ThreadExampleRunnable2("KA"), "t1");
        Thread t2 = new Thread(new ThreadExampleRunnable2("ME"), "t2");
        t1.start();
        t1.join(); //O join faz o t1 terminar toda sua tarefa antes da main poder iniciar a t2. A thread main nao vai ir pra linha 9 enquanto nao terminar a t1.
        t2.start();
    }
}
class ThreadExampleRunnable2 implements Runnable{
    private String c;
    public ThreadExampleRunnable2(String c){
        this.c = c;
    }
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName());
        for (int i = 0; i < 500; i++){
            System.out.print(c);
            if(i % 100 == 0){
                System.out.println();
            }
            Thread.yield(); //Essa e uma indicaçao pro schedular pra thread que esta rodando muito voltar pra runnable e deixar outra rodar. É uma "dica", nao quer dizer que vai
            //acontecer.
        }
    }
}
