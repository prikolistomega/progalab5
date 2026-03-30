package commands;

import exceptions.EmptyDequeException;
import exceptions.InvalidInputException;
import models.Dragon;
import tools.CollectionManager;


public class AverageOfAge extends Command {

    public AverageOfAge(CollectionManager manager){super(manager);}

    public void execute(){
        getManager().averageOfAge();
    }

}