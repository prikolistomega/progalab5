package commands;

import models.Dragon;

import static main_classes.ApplicationContext.collection;

public class Show extends Command {

    public static String execute(){
        String show = "";
        for(var elem : collection){
            show+=elem;
        }
        return show;
    }
}