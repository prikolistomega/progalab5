package models;

import exceptions.InvalidInputException;

import javax.xml.bind.annotation.*;

@XmlAccessorType(XmlAccessType.FIELD)
public class Coordinates {
    @XmlElement
    private Float x; //Поле не может быть null
    @XmlElement
    private Double y; //Значение поля должно быть больше -433, Поле не может быть null

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
