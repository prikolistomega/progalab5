package commands;

import exceptions.InvalidInputException;
import models.Dragon;
import tools.CollectionManager;

import java.util.ArrayDeque;


public class Add extends Command {

    public Add(CollectionManager manager){super(manager);}

    public void execute(){
        getManager().add();
    }
}
