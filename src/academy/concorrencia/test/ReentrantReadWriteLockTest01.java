package academy.concorrencia.test;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.locks.ReentrantReadWriteLock;

class MapReadWrite{ //Com ReadWriteLock vc define locks para leitura e para escrita.
    private final Map<String, String> map = new LinkedHashMap<>();
    private ReentrantReadWriteLock rwl;

    public MapReadWrite(ReentrantReadWriteLock rwl) {
        this.rwl = rwl;
    }

    public void put(String key, String value){
        rwl.writeLock().lock();
        try {
            if (rwl.isWriteLocked()){
                System.out.printf("%s obteve o write lock%n", Thread.currentThread().getName());
            }
            map.put(key, value);
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();

        } finally {
            rwl.writeLock().unlock();
        }
    }

    public Set<String> allKeys(){ //Vc pode ter mais de uma thread obtendo lock de leitura, de escrita somente uma.
        rwl.readLock().lock();
        try {
            return map.keySet();
        }finally {
            rwl.readLock().unlock();
        }
    }
}

public class ReentrantReadWriteLockTest01 {
    public static void main(String[] args) {
        ReentrantReadWriteLock rwl = new ReentrantReadWriteLock();
        MapReadWrite mapReadWrite = new MapReadWrite(rwl);

        Runnable writer = () -> {
            for (int i = 0; i < 20; i++){
                mapReadWrite.put(String.valueOf(i), String.valueOf(i));
            }
        };

        Runnable reader = () -> {
            if (rwl.isWriteLocked()){
                System.out.println("WRITE LOCKED!"); //NAO POSSO PEGAR O LOCK DE LEITURA SE O DE ESCRITA ESTIVER BLOQUEADO.
            }
            rwl.readLock().lock();
            System.out.println("FINALLY I GOT THE LOCK");
            try {
                System.out.println(Thread.currentThread().getName() + " " + mapReadWrite.allKeys());
            } finally {
                rwl.readLock().unlock();
            }
        };

        Thread t1 = new Thread(writer);  //O objetivo desse ReadWriteLock é vc ter o controle de leitura e escrita no mesmo objeto.
        Thread t2 = new Thread(reader); //É um tipo de lock que funciona em par, pq geralmente nao é bom uma thread fazer a leitura ao mesmo tempo em que outra thread esta escrevendo
        Thread t3 = new Thread(reader);
        t1.start();
        t2.start();
        t3.start();
    }
}
