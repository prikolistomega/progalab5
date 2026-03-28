package commands;

import exceptions.RecursionLimitException;
import tools.CollectionManager;
import tools.InputManager;

import java.io.FileNotFoundException;

public class ExecuteScript extends Command{
    private static int runningScripts = 0;
    public static String execute(String path){
        try {
            if (runningScripts >100) throw new RecursionLimitException("Превышен предел рекурсии");
            InputManager reader = new InputManager(path);
            CollectionManager manager = new CollectionManager(reader);
            runningScripts+=1;
            manager.startManage();
            runningScripts-=1;
            return "";
        } catch (FileNotFoundException e) {
            return "Файл не найден\n";
        }catch (RecursionLimitException e){
            return e.getMessage();
        }
    }
}
