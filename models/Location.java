package models;

import exceptions.InvalidInputException;

public class Location {
    private Integer x; //Поле не может быть null
    private Integer y; //Поле не может быть null
    private Integer z; //Поле не может быть null
    private String name; //Поле не может быть null

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
