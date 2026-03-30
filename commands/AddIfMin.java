package commands;

import exceptions.InvalidInputException;
import models.Dragon;
import tools.CollectionManager;


public class AddIfMin extends Command {

    public AddIfMin(CollectionManager manager){super(manager);}

    public void execute(){
        getManager().addIfMin();
    }

}