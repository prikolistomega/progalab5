package models;

import java.util.Date;

public class Dragon implements Comparable<Dragon>{
    private long id; //Поле не может быть null, Значение поля должно быть больше 0, Значение этого поля должно быть уникальным, Значение этого поля должно генерироваться автоматически
    private String name; //Поле не может быть null, Строка не может быть пустой
    private Coordinates coordinates; //Поле не может быть null
    private Date creationDate; //Поле не может быть null, Значение этого поля должно генерироваться автоматически
    private long age; //Значение поля должно быть больше 0
    private Integer weight; //Значение поля должно быть больше 0, Поле может быть null
    private Boolean speaking; //Поле не может быть null
    private Color color; //Поле может быть null
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
