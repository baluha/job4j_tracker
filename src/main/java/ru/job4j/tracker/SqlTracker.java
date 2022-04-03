package ru.job4j.tracker;

import ru.job4j.tracker.model.Item;

import java.io.InputStream;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class SqlTracker implements Store, AutoCloseable {

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
        try (PreparedStatement preparedStatement = cn.prepareStatement("insert into items(name, created) values(?, ?)",
                Statement.RETURN_GENERATED_KEYS)) {
            preparedStatement.setString(1, item.getName());
            preparedStatement.setTimestamp(2, Timestamp.valueOf(item.getCreated()));
            preparedStatement.execute();
            try (ResultSet resultSet = preparedStatement.getGeneratedKeys()) {
                while (resultSet.next()) {
                    item.setId(resultSet.getInt(1));
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return item;
        }


    @Override
    public boolean replace(int id, Item item) {
        boolean result = false;
        try (PreparedStatement preparedStatement =
                     cn.prepareStatement("update item set name = ?, set created = ? where id = ?", Statement.RETURN_GENERATED_KEYS)) {
            preparedStatement.setString(1, item.getName());
            preparedStatement.setTimestamp(2, Timestamp.valueOf(item.getCreated()));
            preparedStatement.setInt(3, id);
            result = preparedStatement.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public boolean delete(int id) {
        boolean result = false;
        try (PreparedStatement preparedStatement =
                     cn.prepareStatement("delete from items where id = ?", Statement.RETURN_GENERATED_KEYS)) {
            preparedStatement.setInt(1, id);
            result = preparedStatement.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public List<Item> findAll() throws SQLException {
        List<Item> list = new ArrayList<>();
        try (PreparedStatement preparedStatement = cn.prepareStatement("select * from items")) {
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                while (resultSet.next()) {
                    list.add(new Item(resultSet.getInt("id"),
                            resultSet.getString("name"),
                            resultSet.getTimestamp("created").toLocalDateTime()));
                }
            }
        }
        return list;
    }

    @Override
    public List<Item> findByName(String key) throws SQLException {
        List<Item> list = new ArrayList<>();
        try (PreparedStatement preparedStatement = cn.prepareStatement("select * from items")) {
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                while (resultSet.next()) {
                    if (key.equals(resultSet.getString(2))) {
                        list.add(new Item(resultSet.getInt("id"),
                                resultSet.getString("name"),
                                resultSet.getTimestamp("created").toLocalDateTime()));
                    }
                }
            }
        }
        return list;
    }

    @Override
    public Item findById(int id) {
        Item item = new Item();
        try (PreparedStatement preparedStatement = cn.prepareStatement("select * from items")) {
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                while (resultSet.next()) {
                    if (id == resultSet.getInt(1)) {
                        item = new Item(resultSet.getInt("id"),
                                resultSet.getString("name"),
                                resultSet.getTimestamp("created").toLocalDateTime());
                        break;
                    }
                }
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return item;
    }

}