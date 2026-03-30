package commands;

import exceptions.InvalidInputException;
import models.Dragon;
import tools.CollectionManager;


public class AddIfMax extends Command {

    public AddIfMax(CollectionManager manager){super(manager);}

    public void execute(){
        getManager().addIfMax();
    }

}