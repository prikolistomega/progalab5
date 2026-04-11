package commands;


import exceptions.InvalidInputException;
import tools.CollectionManager;

public class RemoveById extends Command {

    public RemoveById(CollectionManager manager){super(manager);}
    public RemoveById(){}
    public void execute(){
        try {
            validate();
            getManager().removeById(Long.parseLong((String)getArgs()[0].getValue()));
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
    }
}