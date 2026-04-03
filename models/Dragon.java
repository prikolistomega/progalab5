package models;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.annotation.Nulls;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import exceptions.InvalidInputException;

import java.util.Date;
import java.util.Objects;

@JacksonXmlRootElement(localName = "Dragon")
public class Dragon implements Comparable<Dragon>{
    @JacksonXmlProperty
    private long id;
    @JacksonXmlProperty
    private String name;
    @JacksonXmlProperty
    private Coordinates coordinates;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    @JacksonXmlProperty
    private Date creationDate;
    @JacksonXmlProperty
    private long age;
    @JacksonXmlProperty
    private Integer weight;
    @JacksonXmlProperty
    private Boolean speaking;
    @JacksonXmlProperty
    private Color color;
    @JacksonXmlProperty
    private Person killer;

    public Dragon(){}
    public Dragon(long id, String name, Coordinates coordinates,Date creationDate, long age, Integer weight, Boolean speaking, Color color, Person killer){
        this.id = id;
        this.creationDate = creationDate;
        this.name = name;
        this.coordinates = coordinates;
        this.age = age;
        this.weight = weight;
        this.speaking = speaking;
        this.color = color;
        this.killer = killer;
    }


    @Override
    public String toString(){
        return "Dragon:\n" +
                "id = " + (this.id) + "\n"
                + "name = " + this.name + "\n"
                + "coordinates = {" + (this.coordinates).toString() + "}\n"
                + "creationDate = " + this.creationDate + "\n"
                + "age = " + this.age + "\n"
                + "weight = " + this.weight + "\n"
                + "speaking = " + this.speaking + "\n"
                + "color = " + this.color + "\n"
                + "killer = {" + (this.killer == null ? "null" :(this.killer).toString()) +"}\n\n";
    }

    public long getId(){return id;}
    public String getName(){return name;}
    public long getAge(){return age;}
    public Integer getWeight() {return weight;}
    public Date getCreationDate(){return creationDate;}

    public void setCreationDate(Date date){this.creationDate = date;}
    public void setId(long id){this.id =id;}

    @Override
    public int compareTo(Dragon other){
        if(other ==null) return 1;
        return this.getName().compareTo(other.getName());
    }

    @Override
    public boolean equals(Object obj){
        if(this == obj) return true;
        if(this.hashCode() == obj.hashCode()) return true;
        if(getClass() != obj.getClass()) return false;

        Dragon other = (Dragon) obj;
        return this.id == other.id;
    }

    @Override
    public int hashCode(){
        return Objects.hash(id,name,coordinates,creationDate,age,weight,speaking,color,killer);
    }

    public void validate() throws InvalidInputException {
        if(name==null) throw new InvalidInputException("Неверный формат в элементе");
        if(weight !=null && weight<=0) throw new InvalidInputException("Неверный формат в элементе");
        if(age<=0) throw new InvalidInputException("Неверный формат в элементе");
        if(speaking==null) throw new InvalidInputException("Неверный формат в элементе");
        coordinates.validate();
        if( killer != null && !killer.isEmpty())killer.validate();
    }
}
