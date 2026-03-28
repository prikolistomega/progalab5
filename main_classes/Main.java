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
        try {
            XMLReader xmlReader = new XMLReader();
            ApplicationContext.collection = xmlReader.readXml(args[0]);
        }catch (XmlReadingException e){
            System.out.println(e.getMessage());
            ApplicationContext.collection = new ArrayDeque<Dragon>();
            System.out.println("Коллекция пуста");
        }
        CollectionManager collectionManager = new CollectionManager(new InputManager());
        collectionManager.startManage();
    }
}