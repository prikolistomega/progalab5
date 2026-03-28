package tools;

import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import exceptions.XmlSaveException;
import models.Dragon;

import java.io.File;
import java.io.FileWriter;
import java.util.ArrayDeque;
import java.util.Date;
import java.util.regex.Pattern;


public class XMLWriter {

    public void toXML(ArrayDeque<Dragon> collection){
        try (FileWriter writer = new FileWriter("collection" + NumberOfCollectionCreator.getNumb() +".xml")){
            XmlMapper xmlMapper = new XmlMapper();
            String xml = xmlMapper.writeValueAsString( new CollectionWrapper(collection));
            writer.write(xml);
        }catch (Exception e){
            throw new XmlSaveException("Не удалось сохранить коллекцию");
        }

    }
}

