package main_classes;

import exceptions.XmlReadingException;
import models.Dragon;
import tools.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayDeque;

public class Main{
    public static void main(String[] args){
        ApplicationContext.collectionPath = "collection.xml";
        ArrayDeque<Dragon> collection = new ArrayDeque<Dragon>();
        try {
            XMLReader xmlReader = new XMLReader();
            collection = xmlReader.readXml(ApplicationContext.collectionPath);
        }catch (XmlReadingException e){
            System.out.println(e.getMessage());
            System.out.println("Коллекция пуста");
        }
        Reader reader = new Reader();
        CollectionManager collectionManager = new CollectionManager(collection);
        CommandManager commandManager = new CommandManager(collectionManager,reader);
        commandManager.startManage();
    }
}