package commands;

import exceptions.InvalidInputException;
import tools.CollectionManager;

public class Update extends Command {
    public Update(CollectionManager manager){super(manager);}

    public void execute(){
        try {
            validate();
            getManager().update(Long.parseLong(getArg()));
        }catch (InvalidInputException e){
            System.out.println(e.getMessage());
        }

    }

    public void validate() throws InvalidInputException {
        try{
            Long.parseLong(getArg());
        } catch (NumberFormatException e) {
            throw new InvalidInputException("Неверный формат");
        }
    }
}