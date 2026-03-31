package tools;

import commands.*;
import exceptions.InvalidInputException;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Stack;

public class CommandManager {
    private Reader reader;
    private CollectionManager collectionManager;
    private HashMap<String, Command> commands;

    public CommandManager(CollectionManager collectionManager,Reader reader){
        this.reader = reader;
        this.collectionManager = collectionManager;
        commands = new HashMap<String,Command>();
        commands.put("help",new Help(collectionManager));
        commands.put("info",new Info(collectionManager));
        commands.put("show",new Show(collectionManager));
        commands.put("add",new Add(collectionManager));
        commands.put("update",new Update(collectionManager));
        commands.put("remove_by_id",new RemoveById(collectionManager));
        commands.put("clear",new Clear(collectionManager));
        commands.put("save",new Save(collectionManager));
        commands.put("execute_script",new ExecuteScript(collectionManager));
        commands.put("exit",new Exit(collectionManager));
        commands.put("remove_head",new RemoveHead(collectionManager));
        commands.put("add_if_max",new AddIfMax(collectionManager));
        commands.put("add_if_min",new AddIfMin(collectionManager));
        commands.put("average_of_age",new AverageOfAge(collectionManager));
        commands.put("filter_less_than_age",new FilterLessThanAge(collectionManager));
        commands.put("print_unique_speaking",new PrintUniqueWeight(collectionManager));
    }

    public void startManage(){
        while (true){
            try {
                var str = reader.getLine();
                if(str==null) break;
                String[] splittedStr = str.split(" ");
                if(!commands.containsKey(splittedStr[0])) throw new InvalidInputException("Команда не найдена. Введите help для помощи.");
                Command command = commands.get(splittedStr[0]);
                switch (splittedStr[0]){
                    case "add","add_if_max","add_if_min":
                        command.setArgs(InputManager.inputDragon(reader));
                        break;
                    case "update":
                        command.setArgs(splittedStr[1],InputManager.inputDragon(reader));
                        break;
                    default:
                        command.setArgs((Object[]) Arrays.copyOfRange(splittedStr,1,splittedStr.length));
                        break;
                }
                command.execute();
            }catch (InvalidInputException e){
                System.out.println(e.getMessage());
            }catch (ArrayIndexOutOfBoundsException e){
                System.out.println("Неверный формат");
            }

        }
    }

}
