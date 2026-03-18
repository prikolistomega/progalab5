package main_classes;

import commands.*;
import tools.InputManager;

import java.util.ArrayDeque;

public class Main{
    public static void main(String[] args){
        InputManager im = new InputManager(false);
        ApplicationContext.collection = new ArrayDeque<>();
        var d = im.inputDragon();
        Add.execute(d);
        Show.execute();
        d = im.inputDragon();
        Update.execute(1,d);
        Show.execute();

    }
}