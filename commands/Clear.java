package commands;

import models.Dragon;

import static main_classes.ApplicationContext.collection;

public class Clear extends Command {

    public static String execute(){
        collection.clear();
        return "Коллекция очищена";
    }
}