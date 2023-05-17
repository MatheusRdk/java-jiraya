package concorrencia.test;

import java.util.concurrent.LinkedTransferQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TransferQueue;

public class LinkedTransferQueueTest01 {
    public static void main(String[] args) throws InterruptedException {
        //A LinkedTransferQueue juntou todas as funcionalidades da ConcurrentLinkedQueue, SynchronousQueue, LinkedBlockingQueue
        TransferQueue<Object> tq = new LinkedTransferQueue<>();
        System.out.println(tq.add("Matheus")); //Aqui ele adiciona se houver espaço e retorna true, se nao houver ele da uma exceção.
        System.out.println(tq.offer("Matheus2", 2, TimeUnit.SECONDS)); //Aqui ele adiciona se houver espaço e retorna true, se nao houver ele retorna false. Vc pode colocar o
        //tempo tambem, se quiser que ele espere um tempo antes de tentar colcocar na queue.
        tq.put("Rudek");
        //tq.transfer("Rudek"); //O transfer faz com que o elemento fique esperando até que OUTRA thread venha e pegue ele.
        if(tq.hasWaitingConsumer()){ //Dessa forma vc verifica se tem alguem pra consumir o elemento.
            tq.transfer("Rudek");
        }
        System.out.println(tq.tryTransfer("Memeek")); //Se preferir da pra usar esse ao inves do transfer pra nao precisar fazer o if.
        System.out.println(tq.peek());
        System.out.println(tq.element()); //Igual o peek mas lança exceção se nao achar nenhum elemento.
        System.out.println(tq.poll()); //Igual o remove mas ao inves de lançar uma exceção se a lista estiver vazia só retorna null
        System.out.println(tq.remove());
        System.out.println(tq.take());
        System.out.println(tq.remainingCapacity()); //Verificar a capacidade


    }
}
