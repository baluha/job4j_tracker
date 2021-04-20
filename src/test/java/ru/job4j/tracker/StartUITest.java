package ru.job4j.tracker;

import org.junit.Test;

import java.util.Arrays;

import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsNull.nullValue;
import static org.junit.Assert.*;

public class StartUITest {

    @Test
    public void whenExit() {
        Output out = new StubOutput();
        Input in = new StubInput(
                new String[] {"1", "0"}
        );
        Tracker tracker = new Tracker();
        UserAction[] actions = {
                new ExitAction(out)
        };
        new StartUI(out).init(in, tracker, Arrays.asList(actions));
        assertThat(out.toString(), is(
                String.format(
                        "Menu.%n"
                                + "0. ===EXIT PROGRAM===%n"
                                + "Wrong input, you can select 0 ..1%n"
                                + "Menu.%n"
                                + "0. ===EXIT PROGRAM===%n"
                )
        ));
    }

    @Test
    public void findItemByID() {
        Output output = new StubOutput();
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("Item1"));
        Input input = new StubInput(new String[] {"0", String.valueOf(item.getId()), "1"});
        UserAction[] actions = {
                new FindItemByIDAction(output),
                new ExitAction(output)
        };
        new StartUI(output).init(input, tracker, Arrays.asList(actions));
        assertThat(output.toString(), is(
                "Menu." + System.lineSeparator()
                       + "0. ===Find item by Id==="  + System.lineSeparator()
                       + "1. ===EXIT PROGRAM==="  + System.lineSeparator()
                       + "Item{id=0, name='Item1'}" + System.lineSeparator()
                       + "Menu." + System.lineSeparator()
                       + "0. ===Find item by Id==="  + System.lineSeparator()
                       + "1. ===EXIT PROGRAM===" + System.lineSeparator()));
    }

    @Test
    public void findItemByName() {
        Output output = new StubOutput();
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("item1"));
        Input input = new StubInput(
                new String[] {"0", item.getName(), "1"}
        );
        UserAction[] actions = {
                new FindItemByNameAction(output),
                new ExitAction(output)
        };
        new StartUI(output).init(input, tracker, Arrays.asList(actions));
        assertThat(output.toString(), is(
                "Menu." + System.lineSeparator()
                       + "0. ===Find items by name==="  + System.lineSeparator()
                       + "1. ===EXIT PROGRAM==="  + System.lineSeparator()
                       + "Id = 0, name = item1" + System.lineSeparator()
                       + "Menu." + System.lineSeparator()
                       + "0. ===Find items by name==="  + System.lineSeparator()
                       + "1. ===EXIT PROGRAM===" + System.lineSeparator()));
    }

    @Test
    public void whenReplaceAnotherItem() {
        Output output = new StubOutput();
        Tracker tracker = new Tracker();

        Item item = tracker.add(new Item("Replaced item"));
        String replacedName = "New item name";
        Input in = new StubInput(
                new String[] {"0", String.valueOf(item.getId()), "New item name", "1"}
        );
        UserAction[] actions = {
                new ReplaceAction(output),
                new ExitAction(output)
        };
        new StartUI(output).init(in, tracker, Arrays.asList(actions));
        assertThat(tracker.findById(item.getId()).getName(), is(replacedName));
    }

    @Test
    public void findAllItems() {
        Output output = new StubOutput();
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("item"));
        Input in = new StubInput(
                new String[] {"0", "1"}
        );
        UserAction[] actions = {
                new ShowAllAction(output),
                new ExitAction(output)
        };
        new StartUI(output).init(in, tracker, Arrays.asList(actions));
        assertThat(output.toString(), is(
                "Menu." + System.lineSeparator()
                       + "0. === Showing all items ==="  + System.lineSeparator()
                       + "1. ===EXIT PROGRAM==="  + System.lineSeparator()
                       + "Item{id=0, name='item'}" + System.lineSeparator()
                       + "Menu." + System.lineSeparator()
                       + "0. === Showing all items ==="  + System.lineSeparator()
                       + "1. ===EXIT PROGRAM===" + System.lineSeparator()));
    }

    @Test
    public void whenDeleteAnotherItem() {
        Output output = new StubOutput();
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("Deleted item"));
        Input in = new StubInput(
                new String[] {"0", String.valueOf(item.getId()), "1"}
        );
        UserAction[] actions = {
                new DeleteItemAction(output),
                new ExitAction(output)
        };
        new StartUI(output).init(in, tracker, Arrays.asList(actions));
        assertThat(tracker.findById(item.getId()), is(nullValue()));
    }
}

