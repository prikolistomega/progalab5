package commands;

import models.Dragon;

import static main_classes.ApplicationContext.collection;

public class RemoveById extends Command {

    public static String execute(long id){
        for(var elem : collection){
            if(elem.getId() == id){
                collection.remove(elem);
                return "Элемент удалён";
            }
        }
        return "Элемент не найден";
    }
}