package commands;

import models.Dragon;

import static main_classes.ApplicationContext.collection;
import static main_classes.ApplicationContext.creationTime;

public class Info extends Command {

    public static String execute(){
        String info = String.format("""
                Информация о коллекции:
                
                Тип: ArrayDeque
                Дата инициализации: %s
                Количество элементов: %d
                """,creationTime,collection.size());
        return info;
    }
}