package commands;

import exceptions.InvalidInputException;
import models.Dragon;
import tools.CollectionManager;

public class Update extends Command {
    public Update(CollectionManager manager){super(manager);}

    public void execute(){
        try {
            validate();
            getManager().update(Long.parseLong((String)getArgs()[0]),(Dragon) getArgs()[1]);
        }catch (InvalidInputException e){
            System.out.println(e.getMessage());
        }

    }

    public void validate() throws InvalidInputException {
        try{
            Long.parseLong((String)getArgs()[0]);
        } catch (Exception e) {
            throw new InvalidInputException("Неверный формат");
        }
        if(getArgs().length<2 || !(getArgs()[1] instanceof Dragon)) throw new InvalidInputException("Неверный формат");
    }
}