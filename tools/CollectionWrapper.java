package tools;

import models.Dragon;
import javax.xml.bind.annotation.*;
import java.util.ArrayDeque;

@XmlRootElement(name = "collection")
@XmlAccessorType(XmlAccessType.FIELD)
public class CollectionWrapper {
    @XmlElement(name = "dragon")
    private ArrayDeque<Dragon> collection;

    public CollectionWrapper(ArrayDeque<Dragon> collection){
        this.collection = collection;
    }
}
