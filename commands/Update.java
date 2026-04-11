package commands;

import exceptions.InvalidInputException;
import models.Dragon;
import tools.CollectionManager;

public class Update extends Command {
    public Update(CollectionManager manager){super(manager);}
    public Update(){}
    public void execute(){
        try {
            validate();
            getManager().update(Long.parseLong((String)getArgs()[0].getValue()),(Dragon) getArgs()[1].getValue());
        }catch (InvalidInputException e){
            System.out.println(e.getMessage());
        }

    }

    public void validate() throws InvalidInputException {
        try{
            Long.parseLong((String)getArgs()[0].getValue());
        } catch (Exception e) {
            throw new InvalidInputException("Неверный формат");
        }
        if(getArgs().length<2 || !(getArgs()[1].getValue() instanceof Dragon)) throw new InvalidInputException("Неверный формат");
    }
}