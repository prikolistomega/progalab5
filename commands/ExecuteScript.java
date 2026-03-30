package commands;

import exceptions.InvalidInputException;
import exceptions.RecursionLimitException;
import tools.CollectionManager;
import tools.InputManager;

import java.io.FileNotFoundException;

public class ExecuteScript extends Command{
    public static int runningScripts = 0;

    public ExecuteScript(CollectionManager manager){super(manager);}

    public void execute(){
        try {
            validate();
            getManager().executeScript(getArg());
        }catch (InvalidInputException e){
            System.out.println(e.getMessage());
        }

    }

    public void validate() throws InvalidInputException {
        if(getArg().isEmpty()) throw new InvalidInputException("Неверный формат");
    }
}
