package tools;

import commands.*;
import exceptions.InvalidInputException;
import models.Dragon;

import java.util.ArrayDeque;

public class CollectionManager {
    private InputManager inputManager;

    public CollectionManager(InputManager inputManager){this.inputManager = inputManager;}

    public void startManage(){
        while (true){
            try {
                String command = inputManager.getLine();
                if (command == null) break;
                String[] splitted = command.split(" ");
                if(splitted.length == 0) throw new InvalidInputException("Неверный формат команды");
                switch (splitted[0]) {
                    case "help":
                        if(splitted.length != 1) throw new InvalidInputException("Неверный формат команды");
                        System.out.println(Help.execute());
                        break;
                    case "info":
                        if(splitted.length != 1) throw new InvalidInputException("Неверный формат команды");
                        System.out.println(Info.execute());
                        break;
                    case "show":
                        if(splitted.length != 1) throw new InvalidInputException("Неверный формат команды");
                        System.out.println(Show.execute());
                        break;
                    case "add":
                        if(splitted.length != 1) throw new InvalidInputException("Неверный формат команды");
                        System.out.println(Add.execute(inputManager.inputDragon()));
                        break;
                    case "update":
                        if(splitted.length != 2) throw new InvalidInputException("Неверный формат команды");
                        System.out.println(Update.execute(Long.parseLong(splitted[1]),inputManager.inputDragon()));
                        break;
                    case "remove_by_id":
                        if(splitted.length !=2) throw new InvalidInputException("Неверный формат команды");
                        System.out.println(RemoveById.execute(Long.parseLong(splitted[1])));
                        break;
                    case "clear":
                        if(splitted.length !=1) throw new InvalidInputException("Неверный формат команды");
                        System.out.println(Clear.execute());
                        break;
                    case "save":
                        if(splitted.length !=1) throw new InvalidInputException("Неверный формат команды");
                        System.out.println(Save.execute());
                        break;
                    case "execute_script":
                        if(splitted.length !=2) throw new InvalidInputException("Неверный формат команды");
                        System.out.print(ExecuteScript.execute(splitted[1]));
                        break;
                    case "exit":
                        if(splitted.length !=1) throw new InvalidInputException("Неверный формат команды");
                        System.out.println(Exit.execute());
                        break;
                    case "remove_head":
                        if(splitted.length !=1) throw new InvalidInputException("Неверный формат команды");
                        System.out.println(RemoveHead.execute());
                        break;
                    case "add_if_max":
                        if(splitted.length !=1) throw new InvalidInputException("Неверный формат команды");
                        System.out.println(AddIfMax.execute(inputManager.inputDragon()));
                        break;
                    case "add_if_min":
                        if(splitted.length !=1) throw new InvalidInputException("Неверный формат команды");
                        System.out.println(AddIfMin.execute(inputManager.inputDragon()));
                        break;
                    case "average_of_age":
                        if(splitted.length !=1) throw new InvalidInputException("Неверный формат команды");
                        System.out.println(AverageOfAge.execute());
                        break;
                    case "filter_less_than_age":
                        if(splitted.length !=2) throw new InvalidInputException("Неверный формат команды");
                        System.out.println(FilterLessThanAge.execute(Integer.parseInt(splitted[1])));
                        break;
                    case "print_unique_weight":
                        if(splitted.length !=1) throw new InvalidInputException("Неверный формат команды");
                        System.out.println(PrintUniqueWeight.execute());
                        break;
                    default:
                        System.out.println("Команда не найдена. Введите help для помощи.");
                        break;
                }
            } catch (InvalidInputException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
