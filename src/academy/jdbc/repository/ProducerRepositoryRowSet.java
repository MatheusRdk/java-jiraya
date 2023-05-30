package academy.jdbc.repository;

import academy.jdbc.conn.ConnectionFactory;
import academy.jdbc.dominio.Producer;
import academy.jdbc.listener.CustomRowSetListener;

import javax.sql.rowset.CachedRowSet;
import javax.sql.rowset.JdbcRowSet;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class ProducerRepositoryRowSet {
    public static List<Producer> findByNameJdbcRowSet(String name) {
        String sql = "Select * from anime_store.producer where name like ?;";
        List<Producer> producers = new ArrayList<>();
        try (JdbcRowSet jrs = ConnectionFactory.getJdbcRowSet()) {
            jrs.addRowSetListener(new CustomRowSetListener());
            jrs.setCommand(sql);
            jrs.setString(1, String.format("%%%s%%", name));
            jrs.execute(); //Esse execute é só para buscar, nao para inserir dados.
            while (jrs.next()) {
                Producer producer = Producer.builder().
                        id(jrs.getInt("id")).
                        name(jrs.getString("name"))
                        .build();
                producers.add(producer);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return producers;
    }

//    public static void updateJdbcRowSet(Producer producer) {
//        String sql = "UPDATE `anime_store`.`producer` SET `name` = ? WHERE (`id` = ?);";
//        try (JdbcRowSet jrs = ConnectionFactory.getJdbcRowSet()) {
//            jrs.setCommand(sql);
//            jrs.setString(1, producer.getName());
//            jrs.setInt(2, producer.getId());
//            jrs.execute(); //Esse execute é só para buscar, nao para inserir dados.
//
//            } catch (SQLException e) {
//            e.printStackTrace();
//        }
//    }

    public static void updateJdbcRowSet(Producer producer) {
        String sql = "Select * from anime_store.producer WHERE (`id` = ?);";
        try (JdbcRowSet jrs = ConnectionFactory.getJdbcRowSet()) {
            jrs.addRowSetListener(new CustomRowSetListener());
            jrs.setCommand(sql);
            jrs.setInt(1, producer.getId()); //Troca os wildcards pelo que passar nesses setInt, setString, o index é referente a sequencia que aparece na query.
            jrs.execute();
            if(!jrs.next()) return;
            jrs.updateString("name", producer.getName());
            jrs.updateRow();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void updateCachedRowSet(Producer producer) {
        String sql = "Select * from producer WHERE (`id` = ?);";
        try (CachedRowSet crs = ConnectionFactory.getCachedRowSet();
        Connection connection = ConnectionFactory.getConnection()) {
            connection.setAutoCommit(false);
            crs.setCommand(sql);
            crs.setInt(1, producer.getId());
            crs.execute(connection);
            if(!crs.next()) return;
            crs.updateString("name", producer.getName());
            crs.updateRow();
            TimeUnit.SECONDS.sleep(10); //Se vc alterar os dados lá no mysql workbench enquanto o codigo esta sendo executado nesses 10 segundos, tera um conflito.
            crs.acceptChanges();
        } catch (SQLException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}
