package commands;


import exceptions.InvalidInputException;
import models.Dragon;
import tools.CollectionManager;

import java.util.ArrayDeque;

public abstract class Command {
    private String arg;
    private CollectionManager manager;

    public Command(CollectionManager manager){
        this.manager = manager;
        this.arg = null;
    }
    public Command(CollectionManager manager,String arg){
        this.manager = manager;
        this.arg = arg;
    }

    public void execute(){
    }

    public void validate() throws InvalidInputException{}

    public CollectionManager getManager() {return manager;}
    public String getArg(){return arg;}

    public void setArg(String arg){ this.arg = arg;}
}
