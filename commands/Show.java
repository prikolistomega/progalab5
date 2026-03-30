package commands;

import exceptions.InvalidInputException;
import tools.CollectionManager;

public class Show extends Command {

    public Show(CollectionManager manager){super(manager);}

    public void execute(){
        getManager().show();
    }
}