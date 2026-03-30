package commands;

import exceptions.InvalidInputException;
import models.Dragon;
import tools.CollectionManager;


public class PrintUniqueWeight extends Command {

    public PrintUniqueWeight(CollectionManager manager){super(manager);}

    public void execute(){
        getManager().printUniqueWeight();
    }
}