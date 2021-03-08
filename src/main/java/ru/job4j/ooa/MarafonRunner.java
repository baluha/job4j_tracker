package ru.job4j.ooa;

public class MarafonRunner extends PersonDecorator {
    public MarafonRunner(Person person) {
        super(person);
    }
    public String RunAllDay(){
        return "Running slowly";
    }
    @Override
    public String DoIt(){
        return super.DoIt() + RunAllDay();
    }
}
