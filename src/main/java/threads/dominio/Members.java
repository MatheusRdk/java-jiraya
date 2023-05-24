package threads.dominio;

import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;

public class Members {  //O NOTIFY E O WAIT PRECISAM ESTA EM ALGO SYNCHRONIZED, POIS ELES PRECISAM TER O LOCK.
    private final Queue<String> emails = new ArrayBlockingQueue<>(10); //Esse e um array threadsafe
    private boolean open = true;

    public boolean isOpen(){
        return open;
    }

    public int pendingEmails(){
        synchronized (emails){
            return emails.size();
        }
    }

    public void addMemberEmail(String email){
        synchronized (this.emails){
            String threadName = Thread.currentThread().getName();
            System.out.println(threadName + " adicionou email na lista");
            this.emails.add(email);
            this.emails.notifyAll(); //Aqui vc notifica todas as threads que estao esperando.
        }
    }

    public String retrieveEmail() throws InterruptedException {
        System.out.println(Thread.currentThread().getName() + " checking if there are emails.");
        synchronized (this.emails){
            while (this.emails.size() == 0){ //Esse while é para deixar as threads esperando enquanto nao tem email
                if(!open) return null;
                System.out.println(Thread.currentThread().getName() + " não tem email disponível na lista, entrando em modo de espera.");
                this.emails.wait(); //Essa thread esta esperando ate ser notificada com um notify(). Vc usa um wait pra caso a thread precise fazer algo que ainda nao tem disponivel,
                //ela esperar ao inves de morrer. Pq se ela morrer nao da pra usar ela mais.
            }
            return this.emails.poll();
        }
    }

    public void close(){
        open = false;
        synchronized (this.emails){
            System.out.println(Thread.currentThread().getName() + " notificando todo mundo que não estamos mais pegando emails.");
            this.emails.notifyAll();

        }
    }
}
