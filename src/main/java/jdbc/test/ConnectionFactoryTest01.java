package jdbc.test;

import jdbc.conn.ConnectionFactory;
import jdbc.dominio.Producer;
import jdbc.repository.ProducerRepository;
import lombok.extern.log4j.Log4j2;

@Log4j2
public class ConnectionFactoryTest01 {
    public static void main(String[] args) {
        Producer producer = Producer.builder().name("TikiTaka").build();
        ProducerRepository.save(producer);
    }
}
