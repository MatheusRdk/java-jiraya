package academy.jdbc.test;

import academy.jdbc.dominio.Producer;
import academy.jdbc.service.ProducerService;
import lombok.extern.log4j.Log4j2;

@Log4j2
public class ConnectionFactoryTest01 {
    public static void main(String[] args) {
        Producer producer = Producer.builder().name("Tikorokone").build();
//        ProducerService.save(producer);
        ProducerService.delete(5);
        ProducerService.delete(6);
        ProducerService.delete(7);
        ProducerService.delete(8);
        ProducerService.delete(9);
        ProducerService.delete(10);
        ProducerService.delete(11);
        ProducerService.delete(12);
        ProducerService.delete(13);
    }
}
