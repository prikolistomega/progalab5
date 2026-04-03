package models;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.annotation.Nulls;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import exceptions.InvalidInputException;

import java.text.SimpleDateFormat;
import java.util.Date;

@JacksonXmlRootElement
public class Person {
    @JacksonXmlProperty
    private String name;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    @JacksonXmlProperty
    private java.util.Date birthday;
    @JacksonXmlProperty
    private String passportID;
    @JacksonXmlProperty
    private Country nationality;
    @JacksonXmlProperty
    private Location location;

    public Person(){}
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
                "birthday = " + (new SimpleDateFormat("dd.MM.yyyy")).format(this.birthday) + "\n" +
                "passportID = " + this.passportID + "\n" +
                "nationality = " + this.nationality + "\n" +
                "location = {" + (this.location == null ? "null": (this.location).toString()) + "}\n" ;
    }

    public void validate() throws InvalidInputException{
        if(name.isEmpty()|| birthday==null || passportID == null) throw new InvalidInputException("Неверный формат в элементе");

    }
    @JsonIgnore
    public boolean isEmpty(){
        return name ==null && birthday == null && passportID ==null && location ==null && nationality==null;
    }

}
