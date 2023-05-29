package academy.jdbc.repository;

import academy.jdbc.conn.ConnectionFactory;
import academy.jdbc.dominio.Producer;
import lombok.extern.log4j.Log4j2;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Log4j2
//Com essa anotação vc tem formas mais rapidas de printar coisas na tela ao inves de usar sout. Porem, alem de colocar a dependencia vc precisa criar um xml de configuraçao do
//log4j2, que esta dentro do resources. Lá no <Logger name="academy" level="info" additivity="false">, na parte name vc coloca o pacote que esta todas as classes.
public class ProducerRepository {
    public static void save(Producer producer) {//Sempre que vc abre uma conexão precisa fechar, por isso o try with resources. O statement tambem.
        String sql = "INSERT INTO `anime_store`.`producer` (`name`) VALUES ('%s');".formatted(producer.getName());
        try (Connection conn = ConnectionFactory.getConnection();
             Statement stmt = conn.createStatement()) {
            int rowsAffected = stmt.executeUpdate(sql);
            log.info("Inserted producer '{}'. Database rows affected: '{}'", producer.getName(), rowsAffected);
        } catch (SQLException e) {
            log.error("Error while trying to insert producer '{}'.", producer.getName(), e);
        }
    }

    ;

    public static void delete(int id) {
        String sql = "DELETE FROM `anime_store`.`producer` WHERE (`id` = '%d');".formatted(id);
        try (Connection conn = ConnectionFactory.getConnection();
             Statement stmt = conn.createStatement()) {
            int rowsAffected = stmt.executeUpdate(sql);
            log.info("Deleted producer '{}'. Database rows affected: '{}'", id, rowsAffected);
        } catch (SQLException e) {
            log.error("Error while trying to delete producer '{}'.", id, e);
        }
    }

    ;

    public static void update(Producer producer) {
        String sql = "UPDATE `anime_store`.`producer` SET `name` = '%s ' WHERE (`id` = '%d');".formatted(producer.getName(), producer.getId());
        try (Connection conn = ConnectionFactory.getConnection();
             Statement stmt = conn.createStatement()) {
            int rowsAffected = stmt.executeUpdate(sql);
            log.info("Updated producer '{}'. Database rows affected: '{}'", producer.getId(), rowsAffected);
        } catch (SQLException e) {
            log.error("Error while trying to delete producer '{}'.", producer.getId(), e);
        }
    }

    ;

    public static List<Producer> findAll() {
        log.info("Finding all producers...");
        return findByName("");
    }

    public static List<Producer> findByName(String name) {
        log.info("Finding producers...");
        String sql = "SELECT * FROM anime_store.producer WHERE name LIKE '%%%s%%';"
                .formatted(name);
        List<Producer> producers = new ArrayList<>();
        try (Connection conn = ConnectionFactory.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
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
    }

    public static void showProducerMetaData() {
        log.info("Showing producer metadata...");
        String sql = "SELECT * FROM anime_store.producer;";
        try (Connection conn = ConnectionFactory.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
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
    }

    ;

    public static void showDriverMetaData() { //Isso vai mostrar algumas caracteristicas do database, como se vc pode navegar apenas pra baixo, pra cima, se atualiza informaçoes alteradas
        //por outros ou nao. É como se fosse as permissões dele.
        log.info("Showing driver metadata...");
        try (Connection conn = ConnectionFactory.getConnection()) {
            DatabaseMetaData databaseMetaData = conn.getMetaData();
            if (databaseMetaData.supportsResultSetType(ResultSet.TYPE_FORWARD_ONLY)) {
                log.info("Supports TYPE_FORWARD_ONLY only");
                if (databaseMetaData.supportsResultSetConcurrency(ResultSet.TYPE_FORWARD_ONLY, ResultSet.CONCUR_UPDATABLE)) {
                    log.info("And supports CONCUR_UPDATABLE ");
                }
            }
            if (databaseMetaData.supportsResultSetType(ResultSet.TYPE_SCROLL_INSENSITIVE)) {
                log.info("Supports TYPE_SCROLL_INSENSITIVE only");
                if (databaseMetaData.supportsResultSetConcurrency(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE)) {
                    log.info("And supports CONCUR_UPDATABLE ");
                }
            }
            if (databaseMetaData.supportsResultSetType(ResultSet.TYPE_SCROLL_SENSITIVE)) {
                log.info("Supports TYPE_SCROLL_SENSITIVE only");
                if (databaseMetaData.supportsResultSetConcurrency(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE)) {
                    log.info("And supports CONCUR_UPDATABLE ");
                }
            }
        } catch (SQLException e) {
            log.error("Error while trying to show driver metadata.", e);
        }
    }

    ;

    public static void showTypeScrollWorking() {
        String sql = "SELECT * FROM anime_store.producer;";
        try (Connection conn = ConnectionFactory.getConnection();
             Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
             ResultSet rs = stmt.executeQuery(sql)) {
            log.info("Last row? '{}'", rs.last()); //Quando vc usa esses métodos do rs, o ponteiro vai para onde vc quer. Aqui ele está na ultima linha.
            log.info("Row number? '{}'", rs.getRow());
            log.info(Producer.builder().id(rs.getInt("id")).name(rs.getString("name")).build());

            log.info("First row? '{}'", rs.first()); //Aqui ele está na primeira linha.
            log.info("Row number? '{}'", rs.getRow());
            log.info(Producer.builder().id(rs.getInt("id")).name(rs.getString("name")).build());

            log.info("Row absolute? '{}'", rs.absolute(2)); //Movendo o cursor para a segunda linha diretamente.
            log.info("Row number? '{}'", rs.getRow());
            log.info(Producer.builder().id(rs.getInt("id")).name(rs.getString("name")).build());

            log.info("Row relative? '{}'", rs.relative(-1)); //Com esse vc pode andar pra frente e pra tras. Vc esta movendo o cursor com esses metodos.
            log.info("Row number? '{}'", rs.getRow());
            log.info(Producer.builder().id(rs.getInt("id")).name(rs.getString("name")).build());

            log.info("Is last? '{}'", rs.isLast()); //Com esses metodos vc verifica se é a ultima por ex., sem mover o cursor.
            log.info("Row number? '{}'", rs.getRow());

        } catch (SQLException e) {
            log.error("Error while trying to find all producers.", e);
        }
    }

    ;

    public static List<Producer> findByNameAndUpdateToUppercase(String name) {
        log.info("Finding producers...");
        String sql = "SELECT * FROM anime_store.producer WHERE name LIKE '%%%s%%';"
                .formatted(name);
        List<Producer> producers = new ArrayList<>();
        try (Connection conn = ConnectionFactory.getConnection();
             Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE); //Sempre que vc vai fazer uma alteração no bd vc seta esses parametros.
             //para vc poder fazer as alterações. Se nao fizer ele da uma excessão quando vc tenta alterar.
             ResultSet rs = stmt.executeQuery(sql)) { //Vc pode alterar com um codigo sql diretamente igual no metodo update, porem, isso mostra que vc pode alterar com um resulSet tambem,
            //aproveitando que já tem uma conexão aberta.
            while (rs.next()) {
                rs.updateString("name", rs.getString("name").toUpperCase());
//                rs.cancelRowUpdates();  Sempre que vc quiser voltar um estado usa esse metodo, sempre antes do update, nao adianta ser usado depois que ja for atualizada.
                rs.updateRow();
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
    }

    ;

    public static List<Producer> findByNameAndInsertWhenNotFound(String name) {
        log.info("Finding producers...");
        String sql = "SELECT * FROM anime_store.producer WHERE name LIKE '%%%s%%';"
                .formatted(name);
        List<Producer> producers = new ArrayList<>();
        try (Connection conn = ConnectionFactory.getConnection();
             Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
             ResultSet rs = stmt.executeQuery(sql)) {
            if (rs.next()) return producers;

            rs.moveToInsertRow(); //Primeiro pra inserir vc move pra uma linha temporária
            rs.updateString("name", name);
            rs.insertRow();
            producers.add(getProducer(rs));

        } catch (SQLException e) {
            log.error("Error while trying to find all producers.", e);
        }
        return producers;
    }

    public static void findByNameAndDelete(String name) {
        log.info("Finding producers...");
        String sql = "SELECT * FROM anime_store.producer WHERE name LIKE '%%%s%%';"
                .formatted(name);
        try (Connection conn = ConnectionFactory.getConnection();
             Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                log.info("Deleting {}", rs.getString("name"));
                rs.deleteRow();
            }
        } catch (SQLException e) {
            log.error("Error while trying to delete producers.", e);
        }
    }

    private static Producer getProducer(ResultSet rs) throws SQLException {
        rs.beforeFirst();
        rs.next();
        return Producer.builder().id(rs.getInt("id")).name(rs.getString("name")).build();

    }

    public static List<Producer> findByNamePreparedStatement(String name) { //O preparedStatement foi criado pra ter uma pequena proteção contra SQL Injection e melhorar um pouco
        //a performance do código.
        log.info("Finding producers by name");
        List<Producer> producers = new ArrayList<>();
        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement ps = preparedStatementFindByName(conn, name);
             ResultSet rs = ps.executeQuery()){

            while (rs.next()) {
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
    }

    public static void updatePreparedStatement(Producer producer) {
        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement ps = preparedStatementUpdate(conn, producer)) {
            int rowsAffected = ps.executeUpdate();
            log.info("Updated producer '{}'. Database rows affected: '{}'", producer.getId(), rowsAffected);
        } catch (SQLException e) {
            log.error("Error while trying to update producer '{}'.", producer.getId(), e);
        }
    }

    private static PreparedStatement preparedStatementFindByName(Connection conn, String name) throws SQLException {
        String sql = "SELECT * FROM anime_store.producer WHERE name LIKE ?;";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setString(1, String.format("%%%s%%", name));
        return ps;
    }

    private static PreparedStatement preparedStatementUpdate(Connection conn, Producer producer) throws SQLException {
        String sql = "UPDATE `anime_store`.`producer` SET `name` = ? WHERE (`id` = ?);";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setString(1, producer.getName());
        ps.setInt(2, producer.getId());
        return ps;
    }
}