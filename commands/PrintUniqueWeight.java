package commands;

import models.Dragon;

import java.util.HashSet;

import static main_classes.ApplicationContext.collection;

public class PrintUniqueWeight extends Command {

    public static String execute(){
        HashSet<Integer> set = new HashSet<>();
        for(var elem: collection){
            set.add(elem.getWeight());
        }
        return set.toString();
    }
}