package commands;


import exceptions.InvalidInputException;
import tools.CollectionManager;

public class RemoveById extends Command {

    public RemoveById(CollectionManager manager){super(manager);}

    public void execute(){
        try {
            validate();
            getManager().removeById(Long.parseLong(getArg()));
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