package main_classes;

import exceptions.XmlReadingException;
import models.Dragon;
import tools.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayDeque;

public class Main{
    public static void main(String[] args){
        ArrayDeque<Dragon> collection = new ArrayDeque<Dragon>();
        try {
            XMLReader xmlReader = new XMLReader();
            collection = xmlReader.readXml("collection1.xml");
        }catch (XmlReadingException e){
            System.out.println(e.getMessage());
            System.out.println("Коллекция пуста");
        }
        Reader reader = new Reader();
        CollectionManager collectionManager = new CollectionManager(reader,collection);
        CommandManager commandManager = new CommandManager(collectionManager,reader);
        commandManager.startManage();
    }
}