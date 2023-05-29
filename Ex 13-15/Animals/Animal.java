package Animals;

import java.util.ArrayList;

public class Animal{
    private String name;
    private String birthdate;
    private ArrayList<String> commands;
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
        return null;
    }
    
}