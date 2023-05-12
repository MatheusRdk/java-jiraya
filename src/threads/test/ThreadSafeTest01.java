package threads.test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

class ThreadSafeNames{
    //private final List<String> names = Collections.synchronizedList(new ArrayList<>()); //Essa lista e threadsafe, mas os metodos que acessam ela nao
    private final List<String> names = new ArrayList<>(); //É melhor usar ela normal e deixar os metodos que usam ela threadsafe

    public synchronized void add(String name){
        names.add(name);
    }

    public synchronized void removeFirst(){
        if(names.size() > 0){
            System.out.println(Thread.currentThread().getName());
            System.out.println(names.remove(0));
        }
    }
}

public class ThreadSafeTest01 {

    public static void main(String[] args) { //Classes threadsafe, como a StringBuffer, sao classes com metodos todos synchronized.
        ThreadSafeNames threadSafeNames = new ThreadSafeNames();
        threadSafeNames.add("Junkrat");
        Runnable r = threadSafeNames::removeFirst;
        new Thread(r).start();
        new Thread(r).start();
    }
}
