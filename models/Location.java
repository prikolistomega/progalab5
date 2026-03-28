package models;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import exceptions.InvalidInputException;

@JacksonXmlRootElement
public class Location {
    @JacksonXmlProperty
    private Integer x;
    @JacksonXmlProperty
    private Integer y;
    @JacksonXmlProperty
    private Integer z;
    @JacksonXmlProperty
    private String name;

    public Location(){}
    public Location(int x, int y, int z, String name){
        this.x = x;
        this.y = y;
        this.z = z;
        this.name = name;
    }

    @Override
    public String toString(){
        return "Location : \n" +
                "x = " + this.x + "\n" +
                "y = " + this.y + "\n" +
                "z = " + this.z + "\n" +
                "name = " + this.name + "\n";
    }

}
