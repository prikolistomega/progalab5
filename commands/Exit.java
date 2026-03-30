package commands;

import exceptions.InvalidInputException;
import models.Dragon;
import tools.CollectionManager;

public class Exit extends Command {

    public Exit(CollectionManager manager){super(manager);}

    public void execute(){
        getManager().exit();
    }
}