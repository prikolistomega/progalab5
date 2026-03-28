package tools;

import main_classes.ApplicationContext;

public class IDCreator {
    public static long getDragonId(){
        long id = 1;
        for(var e : ApplicationContext.collection){
            id = Math.max(id,e.getId());
        }
        return id+1;
    }
}
