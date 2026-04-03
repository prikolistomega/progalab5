package tools;

import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import exceptions.XmlReadingException;
import exceptions.XmlSaveException;
import models.Dragon;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayDeque;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class XMLReader {

    public ArrayDeque<Dragon> readXml(String path){
        try {
            String xml = Files.readString(Paths.get(path));
            Pattern pattern = Pattern.compile("<Dragon>(.*?)</Dragon>");
            Matcher matcher = pattern.matcher(xml);
            XmlMapper xmlMapper = new XmlMapper();
            ArrayDeque<Dragon> collection = new ArrayDeque<Dragon>();
            while(matcher.find()){
                try {
                    collection.add(xmlMapper.readValue(matcher.group(), Dragon.class));
                } catch (Exception e) {
                    System.out.println("Ошибка в чтении элемента коллекции, пропущен");
                }
            }
            return collection;
        } catch (Exception e) {
            System.out.println("Ошибка чтения файла, возвращена пустая коллекция");
            return new ArrayDeque<Dragon>();
        }

    }
}
