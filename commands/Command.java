package commands;


import exceptions.InvalidInputException;
import models.Dragon;
import tools.CollectionManager;

import java.util.ArrayDeque;
import java.util.Objects;

public abstract class Command { ;
    private CollectionManager manager;
    private Object[] args;

    public Command(CollectionManager manager){
        this.manager = manager;
    }

    public void execute(){
    }

    public void validate() throws InvalidInputException{}

    public CollectionManager getManager() {return manager;}
    public Object[] getArgs(){return args;}

    public void setArgs(Object... args) {this.args = args;}
}
