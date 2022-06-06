package ru.job4j.tracker;

import ru.job4j.tracker.action.*;
import ru.job4j.tracker.input.ConsoleInput;
import ru.job4j.tracker.input.Input;
import ru.job4j.tracker.input.ValidateInput;
import ru.job4j.tracker.output.ConsoleOutput;
import ru.job4j.tracker.output.Output;
import ru.job4j.tracker.store.MemTracker;

import java.sql.SQLException;
import java.util.List;

    public class StartUIForGC {

        public void init(Input input, Store tracker, List<UserAction> actions) throws SQLException, InterruptedException {
                Thread.sleep(10000);
                UserAction action = actions.get(0);
                action.execute(input, tracker);
                UserAction deleteAction = actions.get(1);
                deleteAction.execute(input, tracker);
        }

        public static void main(String[] args) throws SQLException, InterruptedException {
            Input input = new ValidateInput(
                    new ConsoleInput()
            );
            Store tracker = new MemTracker();
            Output output = new ConsoleOutput();
                List<UserAction> actions = List.of(
                        new GCCreateAction(output),
                        new GCDeleteAction(output),
                        new ExitAction()
                );
                new ru.job4j.tracker.StartUIForGC().init(input, tracker, actions);
        }
}
