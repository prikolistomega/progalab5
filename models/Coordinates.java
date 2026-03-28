package models;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import exceptions.InvalidInputException;


@JacksonXmlRootElement
public class Coordinates {
    @JacksonXmlProperty
    private Float x;
    @JacksonXmlProperty
    private Double y;

    public Coordinates(){}
    public Coordinates(Float x, Double y ){
        this.x = x;
        this.y = y;
    }

    @Override
    public String toString(){
        return "Coordinates: " + "\n"+
                "X = " +this.x + "\n" +
                "Y = " + this.y + "\n";
    }


}
