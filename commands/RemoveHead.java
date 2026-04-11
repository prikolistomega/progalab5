package commands;

import exceptions.EmptyDequeException;
import exceptions.InvalidInputException;
import tools.CollectionManager;

public class RemoveHead extends Command {

    public RemoveHead(CollectionManager manager){super(manager);}
    public RemoveHead(){}
    public void execute(){
        getManager().removeHead();
    }

}