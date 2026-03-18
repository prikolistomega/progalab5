package commands;

import models.Dragon;

import static main_classes.ApplicationContext.collection;

public class Exit extends Command {

    public static String execute(){
        System.exit(0);
        return "";
    }
}