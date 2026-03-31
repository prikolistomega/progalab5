package commands;

import exceptions.InvalidInputException;
import models.Dragon;
import tools.CollectionManager;

public class FilterLessThanAge extends Command {

    public FilterLessThanAge(CollectionManager manager){super(manager);}

    public void execute(){
        try {
            validate();
            getManager().filterLessThanAge(Long.parseLong((String) getArgs()[0]));
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
    }
}