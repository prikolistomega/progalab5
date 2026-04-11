package commands;

import exceptions.InvalidInputException;
import models.Dragon;
import tools.CollectionManager;

import java.util.ArrayDeque;


public class Add extends Command {

    public Add(CollectionManager manager){super(manager);}
    public Add(){}
    public void execute(){
        try {
            validate();
            getManager().add((Dragon) getArgs()[0].getValue());
        } catch (InvalidInputException e) {
            throw new RuntimeException(e);
        }
    }

    public void validate() throws InvalidInputException {
        if(! (getArgs()[0].getValue() instanceof Dragon)) throw new InvalidInputException("Неверный формат");
    }
}
