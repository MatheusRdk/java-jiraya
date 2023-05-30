package academy.jdbc.test;

import academy.jdbc.dominio.Producer;
import academy.jdbc.service.ProducerService;

import java.util.List;

public class ConnectionFactoryTest03 {
    public static void main(String[] args) {
        Producer producer1 = Producer.builder().name("Kakakakashi").build();
        Producer producer2 = Producer.builder().name("Puripuri").build();
        Producer producer3 = Producer.builder().name("Berere").build();

        ProducerService.saveTransaction(List.of(producer1, producer2, producer3));

    }
}
