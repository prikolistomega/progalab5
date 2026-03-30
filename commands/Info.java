package commands;

import exceptions.InvalidInputException;
import models.Dragon;
import tools.CollectionManager;


public class Info extends Command {

    public Info(CollectionManager manager){super(manager);}

    public void execute(){
        getManager().info();
    }

}