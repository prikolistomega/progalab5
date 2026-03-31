package commands;

import exceptions.InvalidInputException;
import models.Dragon;
import tools.CollectionManager;


public class AddIfMin extends Command {

    public AddIfMin(CollectionManager manager){super(manager);}

    public void execute(){
        try {
            validate();
            getManager().addIfMin((Dragon) getArgs()[0]);
        } catch (InvalidInputException e) {
            throw new RuntimeException(e);
        }
    }

    public void validate() throws InvalidInputException {
        if(! (getArgs()[0] instanceof Dragon)) throw new InvalidInputException("Неверный формат");
    }

}