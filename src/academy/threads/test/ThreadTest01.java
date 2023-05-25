package academy.threads.test;

//Criando uma thread
class ThreadExample extends Thread{
    private char c;
    public ThreadExample(char c){
        this.c = c;
    }

    @Override //Quando vc cria uma thread precisa sobreescrever o metodo run para ele rodar, é nele que vai ser executado o código.
    public void run() {
        System.out.println(Thread.currentThread().getName());
        for (int i = 0; i < 500; i++){
            System.out.print(c);
            if(i % 100 == 0){
                System.out.println();
            }
            try {
                Thread.sleep(2_000); //Vc pode pedir pra thread dormir no meio de um processo. Esse e um dos poucos que é garantido de acontecer. Quando vc faz isso, note que
                //a execuçao demora muito mais, pois quando cada thread chega nessa linha dentro do for, ela dorme por dois segundos.
                //Mas por ex., nao e definido que todas vao chegar nessa linha com o mesmo tempo, pois uma thread pode executar o primeiro print la de cima, e parar, entao ela ainda
                //nao vai ter chego na linha do sleep.
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}


public class ThreadTest01 {
    //No java, vc tem dois tipos de thread:
    //O java encerra o programa quando todas as threads do tipo User sao terminadas.
    //Daemon: Nao tem tanta prioridade, é os tipos de thread que cuidam do garbage collector, por ex.
    //User: sao as mais importantes, cuidam dos processos principais.

    public static void main(String[] args) {//Toda vez que vc inicia o metodo main, a thread main é executada. Ela que permite as outras threads iniciarem, mas quem decide quem
//        ThreadExample t1 = new ThreadExample('A');                                                                             //quem esta ativo é o schedular. A main pode parar
//        ThreadExample t2 = new ThreadExample('B');                                                                          //tambem.
//        ThreadExample t3 = new ThreadExample('C');
//        ThreadExample t4 = new ThreadExample('D');         //Vc pode dar nome pras threads
        Thread t1 = new Thread(new ThreadExampleRunnable('A'), "T1A");  //Exemplo com runnable.
        Thread t2 = new Thread(new ThreadExampleRunnable('B'), "T2B"); //Vc precisa dar um cast com new Thread aqui para funcionar a variavel de referencia Thread, é possivel pq Thread
        Thread t3 = new Thread(new ThreadExampleRunnable('C'), "T3C");//tem um construtor sobrecarregado que aceita um runnable.
        Thread t4 = new Thread(new ThreadExampleRunnable('D'), "T4D");//O resultado é igual usando o de cima, porem o jeito recomendado de usar threads é com o runnable.

        //Quando vc da um t1.run(), t2.run(), etc.., vc esta usando a mesma thread. Para usar uma thread nova, vc usa start().
        t4.setPriority(Thread.MAX_PRIORITY); //Vc pode por prioridade pra executar a thread, porem, nao é garantido que isso vai acontecer.
        t1.start(); //Vc nunca pode dar dois starts na mesma thread, vai dar exception sobre o estado da thread.
        t2.start();
        t3.start();
        t4.start();

        //Perceba que agora com o start, o resultado fica bem misturado. No run(), uma thread fez todo o trabalho, por isso ela foi iniciada e fez todo o processo do t1, depois fez
        //todo o processo do t2, e assim por diante. Com o start(), as threads foram iniciadas aleatoriamente, e o trabalho foi feito aos poucos, pois da pra ver que ele fez um pouco
        //do t1, depois um tanto do t2, ai voltou pro t1, iniciou outra thread, fez o t3, voltou pro t1, ou seja, nao é "sequencial" nem definida igual antes com o run(). Tudo é
        //decidido pela JVM, vc nao tem muitas opções. MAS CADA THREAD REALIZA SUA PROPRIA TAREFA, EX.: T1 VAI IMPRIMIR OS A's.

        //Os estados de uma thread: New, Runnable, Waiting/Blocked, Running, Dead
        //Quando vc cria o objeto Thread t1 por ex., ela esta no New, quando vc da um start() ela passa para runnable(nao esta rodando ainda, só quando o schedular "decidir").
        //Quando ela vai para running, esta rodando, e pode ir para Waiting (estar dormindo), ou pode ser bloqueada (blocked). Ela que decide quando ela vai dar uma pausa(waiting), pode
        //ser para esperar um recurso que outra thread esta calculando por ex., as threads nao "mandam" umas nas outras. De waiting/blocked ela volta necessariamente pra runnable.
        //para dai ir para running.
        //Quando tudo está feito ela vai para Dead, dai nao pode ser ativada de novo, tem que criar outro objeto de thread, uma morta nao pode recomeçar.
    }
}


//Outra forma de trabalhar com thread: Classe que implementa o método runnable.
class ThreadExampleRunnable implements Runnable{
    private char c;
    public ThreadExampleRunnable(char c){
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
            try {
                Thread.sleep(2_000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
