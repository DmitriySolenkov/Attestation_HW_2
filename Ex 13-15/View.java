import java.util.ArrayList;
import java.util.Scanner;

import Animals.Animal;
import Animals.Cat;
import Animals.Dog;
import Animals.Hamster;

public class View {
    public static void main(String[] args) {
        ArrayList<String> commands = new ArrayList<String>();
        commands.add("Сидеть");
        commands.add("Голос");
        Dog jimmy = new Dog("Jimmy", "2021-12-27", commands);
        Dog billy = new Dog("Billy", "2019-01-01", commands);
        ArrayList<String> commands1 = new ArrayList<String>();
        commands1.add("Нельзя");
        commands1.add("Брысь");
        Cat marta = new Cat("Marta", "2018-04-17", commands1);
        Cat juna = new Cat("Juna", "2014-10-13", commands1);
        ArrayList<String> commands2 = new ArrayList<String>();
        commands2.add("Есть");
        commands2.add("Не есть");
        Hamster small = new Hamster("Small", "2022-12-17", commands2);
        Hamster big = new Hamster("Big", "2023-01-15", commands2);
        ArrayList<Dog> dogs = new ArrayList<Dog>();
        dogs.add(jimmy);
        dogs.add(billy);
        ArrayList<Cat> cats = new ArrayList<Cat>();
        cats.add(marta);
        cats.add(juna);
        ArrayList<Hamster> hamsters = new ArrayList<Hamster>();
        hamsters.add(small);
        hamsters.add(big);
        menu(dogs, cats, hamsters);

    }

    static int chooseAnswer(int min, int max) {
        Scanner scanner = new Scanner(System.in, "cp866");
        while (true) {
            String input = scanner.nextLine();
            int answer = 0;
            try {
                answer = Integer.parseInt(input);
                if (answer >= min && answer <= max) {
                    return answer;
                } else {
                    throw new Exception();
                }
            } catch (Exception e) {
                System.out.println("Неверно указан вариант ответа!");
            }
        }

    }

    static void printAnimals(ArrayList<Dog> dogs, ArrayList<Cat> cats, ArrayList<Hamster> hamsters) {
        System.out.println("Для отображения всех животных введите 1,\nДля отображения собак введите 2,");
        System.out.println("Для отображения котов введите 3,\nДля отображения хомячков введите 4,");
        System.out.println("Для выхода в меню введите 5:");
        int answer = chooseAnswer(1, 5);
        switch (answer) {
            case 1:
                for (Dog dog : dogs) {
                    System.out.println(dog.animalInfo());
                }
                for (Cat cat : cats) {
                    System.out.println(cat.animalInfo());
                }
                for (Hamster hamster : hamsters) {
                    System.out.println(hamster.animalInfo());
                }
                break;
            case 2:
                for (Dog dog : dogs) {
                    System.out.println(dog.animalInfo());
                }
                break;
            case 3:
                for (Cat cat : cats) {
                    System.out.println(cat.animalInfo());
                }
                break;
            case 4:
                for (Hamster hamster : hamsters) {
                    System.out.println(hamster.animalInfo());
                }
                break;
            case 5:
                break;

        }
    }

    static void menu(ArrayList<Dog> dogs, ArrayList<Cat> cats, ArrayList<Hamster> hamsters) {
        Boolean check = true;
        while (check) {
            System.out.println(
                    "Для отображения содержащихся животных введите 1,\nДля добавления нового животного введите 2,");
            System.out.println("Для обучения животного команде введите 3,\nДля выхода из приложения введите 4:");
            int answer = chooseAnswer(1, 4);
            switch (answer) {
                case 1:
                    printAnimals(dogs, cats, hamsters);
                    break;
                case 2:
                    System.out.println(
                            "Для добавления собаки введите 1,\nДля добавления кота введите 2,");
                    System.out
                            .println("Для добавления хомячка введите 3,\nДля выхода в меню введите 4:");
                    int answer2 = chooseAnswer(1, 4);
                    switch (answer2) {
                        case 1:
                            String name = addName();
                            String birthdate = addBirthdate();
                            ArrayList<String> commands = addCommands();
                            Dog newDog = new Dog(name, birthdate, commands);
                            dogs.add(newDog);
                            break;
                        case 2:
                            String name1 = addName();
                            String birthdate1 = addBirthdate();
                            ArrayList<String> commands1 = addCommands();
                            Cat newCat = new Cat(name1, birthdate1, commands1);
                            cats.add(newCat);
                            break;
                        case 3:
                            String name2 = addName();
                            String birthdate2 = addBirthdate();
                            ArrayList<String> commands2 = addCommands();
                            Hamster newHamster = new Hamster(name2, birthdate2, commands2);
                            hamsters.add(newHamster);
                            break;
                    }
                    break;
                case 3:
                    int[] array = choosePet(dogs, cats, hamsters);
                    switch (array[0]) {
                        case 1:
                            dogs.get(array[1] - 1).addCommand(inputCommand());
                            break;
                        case 2:
                            cats.get(array[1] - 1).addCommand(inputCommand());
                            break;
                        case 3:
                            hamsters.get(array[1] - 1).addCommand(inputCommand());
                            break;
                    }

                    break;
                case 4:
                    System.out.println("Приложение закрывается...");
                    check = false;
            }
        }
    }

    static String addName() {
        Scanner scanner = new Scanner(System.in, "cp866");
        String name = null;
        while (name == null || name.equals("")) {
            System.out.println("Введите имя питомца:");
            name = scanner.nextLine();
        }
        return name;
    }

    static String addBirthdate() {
        Scanner scanner = new Scanner(System.in, "cp866");
        String birthdate = null;
        while (birthdate == null || birthdate.equals("")) {
            System.out.println("Введите дату рождения питомца в формате YYYY-MM-DD:");
            birthdate = scanner.nextLine();
        }
        return birthdate;
    }

    static ArrayList<String> addCommands() {
        Scanner scanner = new Scanner(System.in, "cp866");
        System.out.println("Введите изученные питомцем команды через пробел:");

        String[] commandsArray = scanner.nextLine().split(" ");
        ArrayList<String> commands = new ArrayList<String>();
        for (String command : commandsArray) {
            commands.add(command);
        }
        return commands;

    }

    static int[] choosePet(ArrayList<Dog> dogs, ArrayList<Cat> cats, ArrayList<Hamster> hamsters) {
        int[] array = new int[2];
        System.out.println(
                "Для добавления команды собаке введите 1,\nДля добавления команды коту введите 2,");
        System.out.println("Для добавления команды хомячку введите 3:");
        array[0] = chooseAnswer(1, 3);
        int max = 0;
        switch (array[0]) {

            case 1:
                int index = 1;
                for (Dog dog : dogs) {
                    System.out.print(index + ". ");
                    System.out.println(dog.animalInfo());
                    index++;
                }
                max = dogs.size();
                break;
            case 2:
                int index1 = 1;
                for (Cat cat : cats) {
                    System.out.print(index1 + ". ");
                    System.out.println(cat.animalInfo());
                    index1++;
                }
                max = cats.size();
                break;
            case 3:
                int index2 = 1;
                for (Hamster hamster : hamsters) {
                    System.out.print(index2 + ". ");
                    System.out.println(hamster.animalInfo());
                    index2++;
                }
                max = cats.size()+1;
                break;
        }
        System.out.println("Укажите номер питомца: ");
        array[1] = chooseAnswer(1, max);
        return array;

    }

    static String inputCommand() {
        Scanner scanner = new Scanner(System.in, "cp866");
        System.out.println("Введите команду:");
        return scanner.nextLine();
    }

}
