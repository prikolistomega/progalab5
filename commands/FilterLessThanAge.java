package commands;

import models.Dragon;

import static main_classes.ApplicationContext.collection;

public class FilterLessThanAge extends Command {

    public static String execute(int age){
        String filtredCollection = "";
        for(var elem : collection){
            if(elem.getAge()<age) filtredCollection+=elem.toString();
        }
        return filtredCollection;
    }
}