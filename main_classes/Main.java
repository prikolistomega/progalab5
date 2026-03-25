package main_classes;

import commands.*;
import tools.InputManager;
import tools.XMLWriter;

import java.util.ArrayDeque;

public class Main{
    public static void main(String[] args){
        InputManager im = new InputManager(false);
        ApplicationContext.collection = new ArrayDeque<>();
        var d = im.inputDragon();
        Add.execute(d);
        Show.execute();
        XMLWriter xml = new XMLWriter();
        xml.toXML(ApplicationContext.collection);

    }
}