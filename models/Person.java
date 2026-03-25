package models;

import exceptions.InvalidInputException;

import javax.xml.bind.annotation.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@XmlAccessorType(XmlAccessType.FIELD)
public class Person {
    @XmlElement
    private String name; //Поле не может быть null, Строка не может быть пустой
    @XmlElement
    private java.util.Date birthday; //Поле не может быть null
    @XmlElement
    private String passportID; //Поле может быть null
    @XmlElement
    private Country nationality; //Поле может быть null
    @XmlElement
    private Location location; //Поле может быть null

    public Person(String name, Date birthday, String passportID, Country nationality, Location location){
        this.name = name;
        this.birthday = birthday;
        this.passportID = passportID;
        this.nationality = nationality;
        this.location = location;
    }

    @Override
    public String toString(){
        if(this.name == null) return "null\n";
        return "Person: " +"\n"+
                "name = " + this.name + "\n" +
                "birthday = " + this.birthday + "\n" +
                "passportID = " + this.passportID + "\n" +
                "nationality = " + this.nationality + "\n" +
                "location = {" + (this.location == null ? "null": (this.location).toString()) + "}\n" ;
    }
}
