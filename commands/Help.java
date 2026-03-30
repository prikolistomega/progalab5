package commands;

import exceptions.InvalidInputException;
import tools.CollectionManager;

public class Help extends Command {

    public Help(CollectionManager manager){super(manager);}

    public void execute(){
        getManager().help();
    }

}
