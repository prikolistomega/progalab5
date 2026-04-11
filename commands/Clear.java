package commands;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import exceptions.InvalidInputException;
import models.Dragon;
import tools.CollectionManager;



public class Clear extends Command {

    public Clear(CollectionManager manager){super(manager);}
    public Clear(){}
    public void execute(){
        getManager().clear();
    }

}