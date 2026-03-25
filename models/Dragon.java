package models;

import javax.xml.bind.annotation.*;
import java.util.Date;
@XmlAccessorType(XmlAccessType.FIELD)
public class Dragon implements Comparable<Dragon>{
    @XmlAttribute(name = "id")
    private long id; //Поле не может быть null, Значение поля должно быть больше 0, Значение этого поля должно быть уникальным, Значение этого поля должно генерироваться автоматически
    @XmlElement
    private String name; //Поле не может быть null, Строка не может быть пустой
    @XmlElement
    private Coordinates coordinates; //Поле не может быть null
    @XmlElement
    private Date creationDate; //Поле не может быть null, Значение этого поля должно генерироваться автоматически
    @XmlElement
    private long age; //Значение поля должно быть больше 0
    @XmlElement
    private Integer weight; //Значение поля должно быть больше 0, Поле может быть null
    @XmlElement
    private Boolean speaking; //Поле не может быть null
    @XmlElement
    private Color color; //Поле может быть null
    @XmlElement
    private Person killer; //Поле может быть null
    static long count = 1;

    public Dragon(String name, Coordinates coordinates, long age, Integer weight, Boolean speaking, Color color, Person killer){
        this.id = count;
        count++;
        this.creationDate = new Date();
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
                + "killer = {" + (this.killer == null ? "null" :(this.killer).toString()) +"}\n";
    }

    public long getId(){return id;}
    public String getName(){return name;}
    public long getAge(){return age;}
    public Integer getWeight() {return weight;}

    public void setId(long id){this.id =id;}

    @Override
    public int compareTo(Dragon other){
        if(other ==null) return 1;
        return this.getName().compareTo(other.getName());
    }


}
