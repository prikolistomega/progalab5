package commands;

import models.Dragon;

import static main_classes.ApplicationContext.collection;

public class AddIfMin extends Command {

    public static String execute(Dragon newDragon){
        Boolean isMin = true;
        for(var elem : collection){
            if( newDragon.compareTo(elem) >0) isMin = false;
        }
        if(isMin){
            collection.addLast(newDragon);
            return "Элемент добавлен";
        }
        return "Элемент не минимальный";
    }
}