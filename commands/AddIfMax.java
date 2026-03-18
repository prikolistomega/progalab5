package commands;

import models.Dragon;

import static main_classes.ApplicationContext.collection;

public class AddIfMax extends Command {

    public static String execute(Dragon newDragon){
        Boolean isMax = true;
        for(var elem : collection){
            if( newDragon.compareTo(elem) <0) isMax = false;
        }
        if(isMax){
            collection.addLast(newDragon);
            return "Элемент добавлен";
        }
        return "Элемент не максимальный";
    }
}