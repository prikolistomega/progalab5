package tools;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import commands.Command;
import exceptions.XmlSaveException;
import models.Dragon;

import java.io.File;
import java.io.FileWriter;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Date;
import java.util.regex.Pattern;


public class XMLWriter {

    public void dequeToXML(ArrayDeque<Dragon> collection,String path){
        try (FileWriter writer = new FileWriter(path)){
            XmlMapper xmlMapper = new XmlMapper();
            String xml = xmlMapper.writeValueAsString( new CollectionWrapper(collection));
            writer.write(xml);
        }catch (Exception e){
            throw new XmlSaveException("Не удалось сохранить коллекцию");
        }

    }

    public void journalToXML(CommandList journal){
        try (FileWriter writer = new FileWriter("journal.xml")){
            XmlMapper xmlMapper = new XmlMapper();
            String xml = xmlMapper.writeValueAsString(journal);
            writer.write(xml);
        }catch (Exception e){
            throw new XmlSaveException("Не удалось сохранить журнал");
        }

    }
}

