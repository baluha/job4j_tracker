package ru.job4j.ooa;

public class JavaTeamLead extends DeveloperDecorator {

    public JavaTeamLead(Developer developer) {
        super(developer);
    }
    public String sendWeekReport(){
        return "Send Week report. ";
    }
    @Override
    public String makeJob(){
        return super.makeJob() + sendWeekReport();
    }


}
