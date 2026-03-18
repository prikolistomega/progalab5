package models;

import exceptions.InvalidInputException;

public class Coordinates {

    private Float x; //Поле не может быть null
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
