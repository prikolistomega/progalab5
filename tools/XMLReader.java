package tools;

import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import exceptions.XmlReadingException;
import models.Dragon;

import java.io.File;
import java.io.IOException;
import java.util.ArrayDeque;

public class XMLReader {

    public ArrayDeque<Dragon> readXml(String path){
        try {
            XmlMapper xmlMapper = new XmlMapper();
            CollectionWrapper fromXml = xmlMapper.readValue(new File(path), CollectionWrapper.class);
            if(fromXml.getCollection() == null) return new ArrayDeque<Dragon>();
            return fromXml.getCollection();
        } catch (Exception e) {
            throw new XmlReadingException("Не удалось прочитать xml файл");
        }
    }
}
