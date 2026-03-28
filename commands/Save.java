package commands;

import exceptions.XmlReadingException;
import exceptions.XmlSaveException;
import models.Dragon;
import tools.XMLWriter;

import static main_classes.ApplicationContext.collection;

public class Save extends Command {

    public static String execute(){
        XMLWriter xmlWriter = new XMLWriter();
        try {
            xmlWriter.toXML(collection);
            return "Запись файла прошла успешно";
        }catch (XmlSaveException e){
            return e.getMessage();
        }
    }
}