package commands;

import models.Dragon;

import static main_classes.ApplicationContext.collection;

public class Add extends Command {

    public static String execute(Dragon elem){
        collection.addLast(elem);
        return "Элемент добавлен";
    }
}
