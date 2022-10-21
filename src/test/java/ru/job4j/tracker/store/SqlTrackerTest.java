package ru.job4j.tracker.store;

import org.junit.*;
import ru.job4j.tracker.SqlTracker;
import ru.job4j.tracker.model.Item;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertEquals;

public class SqlTrackerTest {

   private static Connection connection;


    @BeforeClass
    public static void initConnection() {
        try (InputStream in = SqlTrackerTest.class.getClassLoader().getResourceAsStream("test.properties")) {
            Properties config = new Properties();
            config.load(in);
            Class.forName(config.getProperty("driver-class-name"));
            connection = DriverManager.getConnection(
                    config.getProperty("url"),
                    config.getProperty("username"),
                    config.getProperty("password")

            );
        } catch (Exception e) {
            throw new IllegalStateException(e);
        }
    }

    @AfterClass
    public static void closeConnection() throws SQLException {
        connection.close();
    }

    @After
    public void wipeTable() throws SQLException {
        try (PreparedStatement statement = connection.prepareStatement("delete from items")) {
            statement.execute();
        }
    }

    @Test
    public void whenSaveItemAndFindByGeneratedIdThenMustBeTheSame() {
        SqlTracker tracker = new SqlTracker(connection);
        Item item = new Item("item");
        tracker.add(item);
        assertThat(tracker.findById(item.getId()), is(item));
    }

    @Test
    public void whenItemAdd() {
        SqlTracker tracker = new SqlTracker(connection);
        Item item = new Item("item");
        assertThat(tracker.add(item).getName(), is(item.getName()));
    }

    @Test
    public void whenFindAll() {
        SqlTracker tracker = new SqlTracker(connection);
        Item item = new Item("item");
        Item item2 = new Item("item");
        Item item3 = new Item("item");
        tracker.add(item);
        tracker.add(item2);
        tracker.add(item3);
        assertThat(tracker.findAll(), is(List.of(item, item2, item3)));
    }

    @Test
    public void whenReplacingItem() {
        SqlTracker tracker = new SqlTracker(connection);
        Item item = tracker.add(new Item("item"));
        Item item2 = tracker.add(new Item("item2"));
        tracker.replace(item.getId(), item2);
        assertEquals(tracker.findById(item.getId()).getName(), item2.getName());
    }

    @Test
    public void findByName() {
        SqlTracker tracker = new SqlTracker(connection);
        Item item1 = tracker.add(new Item("blablabla"));
        tracker.add(new Item("nanana"));
        tracker.add(new Item("tulula"));
        assertThat(tracker.findByName(item1.getName()), is(List.of(item1)));
    }

    @Test
    public void delete() {
        SqlTracker tracker = new SqlTracker(connection);
        tracker.add(new Item("blablabla"));
        int id = tracker.findByName("blablabla").get(0).getId();
        tracker.delete(id);
        assertThat(tracker.findAll(), is(new ArrayList<>()));
    }
}

