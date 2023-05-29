package Animals;

import java.util.ArrayList;

public class Hamster extends Animal {
    private String name;
    private String birthdate;
    private ArrayList<String> commands;

    
    public Hamster(String name, String birthdate, ArrayList<String> commands) {
        this.name = name;
        this.birthdate = birthdate;
        this.commands = commands;
    }
    
    public String getName() {
        return name;
    }
    public String getBirthdate() {
        return birthdate;
    }
    public ArrayList<String> getCommands() {
        return commands;
    }
    public void addCommand(String command) {
        commands.add(command);
    }
    public String animalInfo() {
        String info="Имя: " + name + ", Дата рождения: " + birthdate;
        if (commands != null)
        info = info+ "\n    Знает команды:";
        for (String command : commands) {
            info=info+ "\n      "+ command;
        }

        return info;
    }
}