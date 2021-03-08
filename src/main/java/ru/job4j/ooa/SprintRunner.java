package ru.job4j.ooa;

public class SprintRunner extends PersonDecorator {
    public SprintRunner(Person person) {
        super(person);
    }
    public String RunSrint(){
        return "Fast run!";
    }
    @Override
    public String DoIt(){
        return super.DoIt() + RunSrint();
    }
}
