package tools;

import models.Dragon;

import javax.xml.bind.*;
import java.io.File;
import java.io.FileWriter;
import java.util.ArrayDeque;
import java.util.Date;


public class XMLWriter {

    public int toXML(ArrayDeque<Dragon> collection){
        try{
            JAXBContext context =JAXBContext.newInstance(CollectionWrapper.class);
            Marshaller marshaller = context.createMarshaller();

            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

            File file = new File("collection.xml");
            marshaller.marshal(collection,file);
            return 0;
        }catch (Exception e){
            System.out.println(e.getMessage());
            return 1;
        }
    }
}

