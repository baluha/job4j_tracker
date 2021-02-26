package ru.job4j.tracker;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsNull.nullValue;
import static org.junit.Assert.*;

public class StartUITest {

    @Test
    public void whenExit() {
        Output out = new StubOutput();
        Input in = new StubInput(
                new String[] {"0"}
        );
        Tracker tracker = new Tracker();
        UserAction[] actions = {
                new ExitAction(out)
        };
        new StartUI(out).init(in, tracker, actions);
        assertThat(out.toString(), is(
                "Menu." + System.lineSeparator() +
                        "0. Exit" + System.lineSeparator()
        ));
    }

    @Test
    public void whenCreateItem() {
        Output output = new StubOutput();
        Input in = new StubInput(
                new String[] {"0", "Item name", "1"}
        );
        Tracker tracker = new Tracker();
        UserAction[] actions = {
                new CreateAction(output),
                new ExitAction(output)
        };
        new StartUI(output).init(in, tracker, actions);
        assertThat(tracker.findAll()[0].getName(), is("Item name"));
    }


    @Test
    public void findItemByID() {
        Output output = new StubOutput();
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("Item1"));
        Input input = new StubInput( new String[] {"0", String.valueOf(item.getId()), "1"} );
        UserAction[] actions = {
                new FindItemByIDAction(output),
                new ExitAction(output)
        };
        new StartUI(output).init(input, tracker, actions);
        assertThat(tracker.findById(item.getId()), is(item));
    }

    @Test
    public void findItemByName() {
        Output output = new StubOutput();
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("item1"));
        Item item1 = tracker.add(new Item("item2"));
        Item item2 = tracker.add(new Item("item3"));
        Item item3 = tracker.add(new Item("item1"));
        Item item4 = tracker.add(new Item("item4"));
        Item[] items = tracker.findByName("item1");
        Input input = new StubInput(
                new String[] {"0", item.getName(), "1"}
        );
        UserAction[] actions = {
                new FindItemByNameAction(output),
                new ExitAction(output)
        };
        new StartUI(output).init(input, tracker, actions);
        assertThat(tracker.findByName("item1"), is(items));
    }

    @Test
    public void whenReplaceAnotherItem() {
        Output output = new StubOutput();
        Tracker tracker = new Tracker();
        /* Добавим в tracker новую заявку */
        Item item = tracker.add(new Item("Replaced item"));
        String replacedName = "New item name";
        Input in = new StubInput(
                new String[] {"0", String.valueOf(item.getId()), "New item name", "1"}
        );
        UserAction[] actions = {
                new ReplaceAction(output),
                new ExitAction(output)
        };
        new StartUI(output).init(in, tracker, actions);
        assertThat(tracker.findById(item.getId()).getName(), is(replacedName));
    }

    @Test
    public void findAllItems() {
        Output output = new StubOutput();
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("item"));
        Item item1 = tracker.add(new Item("item1"));
        Item item2 = tracker.add(new Item("item2"));
        Item item3 = tracker.add(new Item("item3"));
        Item item4 = tracker.add(new Item("item4"));
        Item [] items = tracker.findAll();
        Input in = new StubInput(
                new String[] {"0", "1"}
        );
        UserAction[] actions = {
                new ShowAllAction(output),
                new ExitAction(output)
        };
        new StartUI(output).init(in, tracker, actions);
        assertThat(tracker.findAll(), is(items));
    }
    @Test
    public void whenDeleteAnotherItem() {
        Output output = new StubOutput();
        Tracker tracker = new Tracker();
        /* Добавим в tracker новую заявку */
        Item item = tracker.add(new Item("Deleted item"));
        /* Входные данные должны содержать ID добавленной заявки item.getId() */
        Input in = new StubInput(
                new String[] {"0", String.valueOf(item.getId()), "1"}
        );
        UserAction[] actions = {
                new DeleteItemAction(output),
                new ExitAction(output)
        };
        new StartUI(output).init(in, tracker, actions);
        assertThat(tracker.findById(item.getId()), is(nullValue()));
    }
}

