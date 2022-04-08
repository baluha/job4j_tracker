package ru.job4j.tracker;

import org.slf4j.LoggerFactory;
import ru.job4j.tracker.model.Item;

import java.io.InputStream;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import org.slf4j.Logger;

public class SqlTracker implements Store, AutoCloseable {

    private static final Logger LOG = LoggerFactory.getLogger(SqlTracker.class.getName());
    private Connection cn;

    public void init() {
        try (InputStream in = SqlTracker.class.getClassLoader().getResourceAsStream("app.properties")) {
            Properties config = new Properties();
            config.load(in);
            Class.forName(config.getProperty("driver-class-name"));
            cn = DriverManager.getConnection(
                    config.getProperty("url"),
                    config.getProperty("username"),
                    config.getProperty("password")
            );
        } catch (Exception e) {
            throw new IllegalStateException(e);
        }
    }

    @Override
    public void close() throws Exception {
        if (cn != null) {
            cn.close();
        }
    }

    @Override
    public Item add(Item item) throws SQLException {
        if (item.getName().isBlank()) {
            try {
                throw new IllegalArgumentException("Item name not found");
            } catch (IllegalArgumentException i) {
                LOG.error("Name is empty", i);
            }
        }
        try (PreparedStatement preparedStatement = cn.prepareStatement("insert into items(name, created) values(?, ?)",
                Statement.RETURN_GENERATED_KEYS)) {
            preparedStatement.setString(1, item.getName());
            preparedStatement.setTimestamp(2, Timestamp.valueOf(item.getCreated()));
            preparedStatement.execute();
            try (ResultSet resultSet = preparedStatement.getGeneratedKeys()) {
                while (resultSet.next()) {
                    item.setId(resultSet.getInt(1));
                }
            }
        }
        if (!item.getName().isBlank()) {
            LOG.info("Item successful added id : {}, name : {} !", item.getName(), item.getName());
        }
        return item;
        }


    @Override
    public boolean replace(int id, Item item) throws SQLException {
        if (item.getName().isBlank() || id <= 0) {
            try {
            throw new IllegalArgumentException("Item is empty or id does not exist!");
        } catch (IllegalArgumentException i) {
        LOG.error("log ", i);
        }
        }
        boolean result = false;
        try (PreparedStatement preparedStatement =
                     cn.prepareStatement("update items set name = ?, created = ? where id = ?")) {
            preparedStatement.setString(1, item.getName());
            preparedStatement.setTimestamp(2, Timestamp.valueOf(item.getCreated()));
            preparedStatement.setInt(3, id);
            result = preparedStatement.executeUpdate() > 0;
        }
        LOG.info("Replacing successful!");
        return result;
    }

    @Override
        public boolean delete(int id) throws SQLException {
        if (id <= 0) {
            try {
                throw new IllegalArgumentException("Id does not exist!");
            } catch (IllegalArgumentException i) {
                LOG.error("log ", i);
            }
        }
            boolean result = false;
            try (PreparedStatement preparedStatement =
                         cn.prepareStatement("delete from items where id = ?")) {
                preparedStatement.setInt(1, id);
                result = preparedStatement.executeUpdate() > 0;
            }
        LOG.info("Item successful deleted !");
            return result;
        }


    @Override
    public List<Item> findAll() throws SQLException {
        List<Item> list = new ArrayList<>();
        try (PreparedStatement preparedStatement = cn.prepareStatement("select * from items")) {
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                while (resultSet.next()) {
                    list.add(returningItem(resultSet));
                }
            }
        }
        if (list.size() == 0) {
            try {
                throw new IllegalArgumentException("List is empty");
            } catch (IllegalArgumentException i) {
                LOG.error("log ", i);
            }
        }
        if (list.size() > 0) {
            LOG.info("All items successfully find!");
        }
        return list;
    }

    @Override
    public List<Item> findByName(String key) throws SQLException {
        if (key.isBlank()) {
            try {
            throw new IllegalArgumentException("key is empty");
        } catch (IllegalArgumentException i) {
            LOG.error("log ", i);
        }
        }
        List<Item> list = new ArrayList<>();
        try (PreparedStatement preparedStatement = cn.prepareStatement("select * from items where name = ?")) {
            preparedStatement.setString(1, key);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                while (resultSet.next()) {
                    list.add(returningItem(resultSet));
                }
            }
        }
        if (list.size() == 0) {
            try {
                throw new IllegalArgumentException("List is empty");
            } catch (IllegalArgumentException i) {
                LOG.error("log ", i);
            }
        }
        if (list.size() > 0) {
            LOG.info("All items successfully find!");
        }
        return list;
    }

    @Override
    public Item findById(int id) {
        Item item = new Item();
        try (PreparedStatement preparedStatement = cn.prepareStatement("select * from items where id = ?")) {
            preparedStatement.setInt(1, id);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                while (resultSet.next()) {
                        item = returningItem(resultSet);
                        break;
                }
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        if (item == null || item.getId() == 0) {
            try {
                throw new IllegalArgumentException("Item or item ID is null");
            } catch (IllegalArgumentException i) {
                LOG.error("log ", i);
            }

        }
        if (item != null) {
            LOG.info("Item find!");
        }
        return item;
    }
    public Item returningItem(ResultSet rslSet) throws SQLException {
        return new Item(rslSet.getInt("id"),
                rslSet.getString("name"),
                rslSet.getTimestamp("created").toLocalDateTime());
    }
}