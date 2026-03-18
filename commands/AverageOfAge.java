package commands;

import exceptions.EmptyDequeException;
import models.Dragon;

import static main_classes.ApplicationContext.collection;

public class AverageOfAge extends Command {

    public static String execute(){
        try {
            if(collection.isEmpty()) throw new EmptyDequeException("Коллекция пуста");
            Float sum = 0F;
            for(var elem : collection){
                sum+= (float) elem.getAge();
            }
            Float average = sum/(float)collection.size();
            return average.toString();
        }catch (EmptyDequeException e){
            return e.getMessage();
        }

    }
}