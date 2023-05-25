package academy.concorrencia.dominio;

import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class Members {
    private final Queue<String> emails = new ArrayBlockingQueue<>(10);
    private final ReentrantLock lock = new ReentrantLock();
    private final Condition condition = lock.newCondition(); //Para usar o notify e wait com lock manual assim, precisa criar esse condition.
    private boolean open = true;

    public boolean isOpen() {
        return open;
    }

    public int pendingEmails() {
        lock.lock();
        try {
            return emails.size();
        } finally {
            lock.unlock();
        }
    }

    public void addMemberEmail(String email) {
        lock.lock();
        try {
            String threadName = Thread.currentThread().getName();
            System.out.println(threadName + " adicionou email na lista");
            this.emails.add(email);
            condition.signalAll(); //Com lock, para dar o notify é com esse signal
        } finally {
            lock.unlock();
        }
    }

    public String retrieveEmail() throws InterruptedException {
        System.out.println(Thread.currentThread().getName() + " checking if there are emails.");
        lock.lock();
        try {
            while (this.emails.size() == 0) { //Esse while é para deixar as threads esperando enquanto nao tem email
                if (!open) return null;
                System.out.println(Thread.currentThread().getName() + " não tem email disponível na lista, entrando em modo de espera.");
                condition.await();
            }
            return this.emails.poll();
        } finally {
            lock.unlock();
        }
    }

    public void close() {
        open = false;
        lock.lock();
        try {
            System.out.println(Thread.currentThread().getName() + " notificando todo mundo que não estamos mais pegando emails.");
            condition.signalAll();

        } finally {
            lock.unlock();
        }
    }
}
