package commands;

import exceptions.EmptyDequeException;
import models.Dragon;

import static main_classes.ApplicationContext.collection;

public class RemoveHead extends Command {

    public static String execute(){
        try {
            if(collection.isEmpty()) throw new EmptyDequeException("Коллекция пуста");
            return (collection.poll()).toString();
        } catch (EmptyDequeException e) {
            return e.getMessage();
        }
    }
}