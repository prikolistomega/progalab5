package commands;

import models.Dragon;

import java.util.ArrayDeque;
import java.util.Arrays;

import static main_classes.ApplicationContext.collection;

public class Update extends Command {

    public static String execute(long id, Dragon updDragon){
        Dragon[] array = collection.toArray(new Dragon[0]);
        for(int i =0;i< array.length;i++){
            if(array[i].getId() == id){
                array[i] = updDragon;
                array[i].setId(id);
                collection = new ArrayDeque<>(Arrays.asList(array));
                return "Элемент обновлён";
            }
        }
        return "Элемент не найден";

    }
}