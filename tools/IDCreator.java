package tools;

import main_classes.ApplicationContext;
import models.Dragon;

import java.util.ArrayDeque;

public class IDCreator {
    public static long getDragonId(ArrayDeque<Dragon> collection){
        long id = 1;
        for(var e : collection){
            id = Math.max(id,e.getId());
        }
        return id+1;
    }
}
