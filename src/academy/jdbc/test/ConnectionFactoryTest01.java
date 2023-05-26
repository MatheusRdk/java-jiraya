package academy.jdbc.test;

import academy.jdbc.dominio.Producer;
import academy.jdbc.service.ProducerService;
import lombok.extern.log4j.Log4j2;

@Log4j2
public class ConnectionFactoryTest01 {
    public static void main(String[] args) {
        Producer producer = Producer.builder().name("Kakakakashi").build();
        Producer producerToUpdate = Producer.builder().id(1).name("MADHOUSE").build();
//        ProducerService.save(producer);
//        ProducerService.delete(5);
        ProducerService.update(producerToUpdate);
    }
}
