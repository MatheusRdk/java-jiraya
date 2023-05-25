package academy.jdbc.repository;

import academy.jdbc.conn.ConnectionFactory;
import academy.jdbc.dominio.Producer;
import lombok.extern.log4j.Log4j2;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

@Log4j2  //Com essa anotação vc tem formas mais rapidas de printar coisas na tela ao inves de usar sout. Porem, alem de colocar a dependencia vc precisa criar um xml de configuraçao do
//log4j2, que esta dentro do resources. Lá no <Logger name="academy" level="info" additivity="false">, na parte name vc coloca o pacote que esta todas as classes.
public class ProducerRepository {
    public static void save(Producer producer){//Sempre que vc abre uma conexão precisa fechar, por isso o try with resources. O statement tambem.
        String sql = "INSERT INTO `anime_store`.`producer` (`name`) VALUES ('%s');".formatted(producer.getName());
        try(Connection conn = ConnectionFactory.getConnection();
            Statement stmt = conn.createStatement()){
            int rowsAffected = stmt.executeUpdate(sql);
            log.info("Inserted producer '{}'. Database rows affected: '{}'", producer.getName(), rowsAffected);
        } catch (SQLException e) {
            log.error("Error while trying to insert producer '{}'.", producer.getName(), e);
        }
    };

    public static void delete(int id){
        String sql = "DELETE FROM `anime_store`.`producer` WHERE (`id` = '%d');".formatted(id);
        try(Connection conn = ConnectionFactory.getConnection();
            Statement stmt = conn.createStatement()){
            int rowsAffected = stmt.executeUpdate(sql);
            log.info("Deleted producer '{}'. Database rows affected: '{}'", id, rowsAffected);
        } catch (SQLException e) {
            log.error("Error while trying to delete producer '{}'.", id, e);
        }
    };
}
