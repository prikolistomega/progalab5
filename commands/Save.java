package commands;


import exceptions.InvalidInputException;
import tools.CollectionManager;

public class Save extends Command {

    public Save(CollectionManager manager){super(manager);}
    public Save(){}
    public void execute(){
        getManager().save();
    }
}