package jdbc.repository;

import jdbc.conn.ConnectionFactory;
import jdbc.dominio.Producer;
import lombok.extern.log4j.Log4j2;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

@Log4j2  //Com essa anotação vc tem formas mais rapidas de printar coisas na tela ao inves de usar sout. Porem, alem de colocar a dependencia vc precisa criar um xml de configuraçao do
//log4j2, que esta dentro do resources.
public class ProducerRepository {
    public static void save(Producer producer){//Sempre que vc abre uma conexão precisa fechar, por isso o try with resources. O statement tambem.
        String sql = "INSERT INTO `anime_store`.`producer` (`name`) VALUES ('%s');".formatted(producer.getName());
        try(Connection conn = ConnectionFactory.getConnection();
            Statement stmt = conn.createStatement()){
            int rowsAffected = stmt.executeUpdate(sql);
            log.info("Database rows affected: '{}'", rowsAffected);
        } catch (SQLException e) {
             e.printStackTrace();
        }
    };
}
