package academy.jdbc.test;

import academy.jdbc.dominio.Producer;
import academy.jdbc.service.ProducerServiceRowSet;
import lombok.extern.log4j.Log4j2;

import java.util.List;

@Log4j2
public class ConnectionFactoryTest02 {
    public static void main(String[] args) {
        Producer producerToUpdate = Producer.builder().id(1).name("MemeHOUSE").build();
        ProducerServiceRowSet.updateJdbcRowSet(producerToUpdate);
        log.info("------------");
        List<Producer> producers = ProducerServiceRowSet.findByNameJdbcRowSet("");
        log.info(producers);
    }
}
