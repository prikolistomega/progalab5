package commands;

import exceptions.InvalidInputException;
import models.Dragon;
import tools.CollectionManager;


public class AddIfMax extends Command {

    public AddIfMax(CollectionManager manager){super(manager);}
    public AddIfMax(){}
    public void execute(){
        try {
            validate();
            getManager().addIfMax((Dragon) getArgs()[0].getValue());
        } catch (InvalidInputException e) {
            throw new RuntimeException(e);
        }
    }

    public void validate() throws InvalidInputException {
        if(! (getArgs()[0].getValue() instanceof Dragon)) throw new InvalidInputException("Неверный формат");
    }
    
}