package main_classes;

import exceptions.XmlReadingException;
import models.Dragon;
import tools.CollectionManager;
import tools.CollectionWrapper;
import tools.InputManager;
import tools.XMLReader;

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
        CollectionManager collectionManager = new CollectionManager(new InputManager(),collection);
        collectionManager.startManage();
    }
}