package academy.jdbc.test;

import academy.jdbc.dominio.Producer;
import academy.jdbc.service.ProducerService;
import lombok.extern.log4j.Log4j2;

import java.util.List;

@Log4j2
public class ConnectionFactoryTest01 {
    public static void main(String[] args) {
        Producer producer = Producer.builder().name("Kakakakashi").build();
        Producer producerToUpdate = Producer.builder().id(1).name("madhouse").build();
//        ProducerService.save(producer);
//        ProducerService.delete(5);
//        ProducerService.update(producerToUpdate);
//        List<Producer> producers = ProducerService.findAll();
//        List<Producer> producers = ProducerService.findByName("T");
//        log.info("Producers found: {}", producers);
//        ProducerService.showProducerMetaData();
//        ProducerService.showTypeScrollWorking();
//        List<Producer> producers = ProducerService.findByNameAndUpdateToUppercase("Tikorokone");
//        List<Producer> producers = ProducerService.findByNameAndInsertWhenNotFound("A-1T-2-B");
//        ProducerService.findByNameAndDelete("A-1T-2-B");
//        List<Producer> byNamePreparedStatement = ProducerService.findByNamePreparedStatement("B"); //SQL injection. Quando vc deixa o codigo assim la no metodo:
//        //      String sql = "SELECT * FROM anime_store.producer WHERE name LIKE '%s';.formatted(name);" com um statement normal, vc abre brechas pra alguem acessar
//        //      todo o banco de dados com uma expresão como aquela.
//        //Apos arrumar todo o metodo com o preparedstatement o sql injection nao funciona mais.
//
//        log.info("Producers found: {}", byNamePreparedStatement);
//        ProducerService.updatePreparedStatement(producerToUpdate);
        List<Producer> producers = ProducerService.findByNameCallableStatement("iii");
        log.info("Producers found: {}", producers);
    }
}
