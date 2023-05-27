package academy.jdbc.repository;

import academy.jdbc.conn.ConnectionFactory;
import academy.jdbc.dominio.Producer;
import lombok.extern.log4j.Log4j2;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

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

    public static void update(Producer producer){
        String sql = "UPDATE `anime_store`.`producer` SET `name` = '%s ' WHERE (`id` = '%d');".formatted(producer.getName(), producer.getId());
        try(Connection conn = ConnectionFactory.getConnection();
            Statement stmt = conn.createStatement()){
            int rowsAffected = stmt.executeUpdate(sql);
            log.info("Updated producer '{}'. Database rows affected: '{}'", producer.getId(), rowsAffected);
        } catch (SQLException e) {
            log.error("Error while trying to delete producer '{}'.", producer.getId(), e);
        }
    };

    public static List<Producer> findAll(){
        log.info("Finding all producers...");
        return findByName("");
    }

    public static List<Producer> findByName(String name){
        log.info("Finding producers...");
        String sql = "SELECT * FROM anime_store.producer WHERE name LIKE '%%%s%%';"
                .formatted(name);
        List<Producer> producers = new ArrayList<>();
        try(Connection conn = ConnectionFactory.getConnection();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql)){
            while (rs.next()){
                Producer producer = Producer.builder()
                        .id(rs.getInt("id"))
                        .name(rs.getString("name"))
                        .build();
                producers.add(producer);
            }
        } catch (SQLException e) {
            log.error("Error while trying to find all producers.", e);
        }
        return producers;
    };

    public static void showProducerMetaData(){
        log.info("Showing producer metadata...");
        String sql = "SELECT * FROM anime_store.producer;";
        try(Connection conn = ConnectionFactory.getConnection();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql)){
            ResultSetMetaData metaData = rs.getMetaData();
            int columnCount = metaData.getColumnCount();
            log.info("Columns count: {}", columnCount);
            for (int i = 1; i <= columnCount; i++) {
                log.info("Table name: {}", metaData.getTableName(i));
                log.info("Column name: {}", metaData.getColumnName(i));
                log.info("Column size: {}", metaData.getColumnDisplaySize(i));
                log.info("Column type: {}", metaData.getColumnTypeName(i));
            }
        } catch (SQLException e) {
            log.error("Error while trying to show producer metadata.", e);
        }
    };

    public static void showDriverMetaData(){ //Isso vai mostrar algumas caracteristicas do database, como se vc pode navegar apenas pra baixo, pra cima, se atualiza informaçoes alteradas
        //por outros ou nao. É como se fosse as permissões dele.
        log.info("Showing driver metadata...");
        try(Connection conn = ConnectionFactory.getConnection()){
            DatabaseMetaData databaseMetaData = conn.getMetaData();
            if(databaseMetaData.supportsResultSetType(ResultSet.TYPE_FORWARD_ONLY)){
                log.info("Supports TYPE_FORWARD_ONLY only");
                if(databaseMetaData.supportsResultSetConcurrency(ResultSet.TYPE_FORWARD_ONLY, ResultSet.CONCUR_UPDATABLE)){
                    log.info("And supports CONCUR_UPDATABLE ");
                }
            }
            if(databaseMetaData.supportsResultSetType(ResultSet.TYPE_SCROLL_INSENSITIVE)){
                log.info("Supports TYPE_SCROLL_INSENSITIVE only");
                if(databaseMetaData.supportsResultSetConcurrency(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE)){
                    log.info("And supports CONCUR_UPDATABLE ");
                }
            }
            if(databaseMetaData.supportsResultSetType(ResultSet.TYPE_SCROLL_SENSITIVE)){
                log.info("Supports TYPE_SCROLL_SENSITIVE only");
                if(databaseMetaData.supportsResultSetConcurrency(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE)){
                    log.info("And supports CONCUR_UPDATABLE ");
                }
            }
        } catch (SQLException e) {
            log.error("Error while trying to show driver metadata.", e);
        }
    };
}