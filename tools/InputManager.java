package tools;


import exceptions.InvalidInputException;
import models.*;

import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class InputManager {

    private BufferedReader inputReader;
    private String scriptPath;


    public InputManager(){
        inputReader = new BufferedReader(new InputStreamReader(System.in));
    }

    public InputManager(String scriptPath) throws FileNotFoundException{


        FileInputStream fileInputStream = new FileInputStream(scriptPath);
        inputReader = new BufferedReader(new InputStreamReader(fileInputStream));

    }

    public String getLine(){

        try {
            return inputReader.readLine();
        } catch (IOException e) {
            System.out.println(e.getMessage());
            System.out.println("Не удалось прочесть строку");
        }
        return null;
    }

    public Integer inputInt(boolean nullable){
        while(true){
            var str = this.getLine();
            if(nullable && str.isEmpty()) return null;
            try{
                if(str.isEmpty()) throw new InvalidInputException("");
                return Integer.parseInt(str);
            }catch(InvalidInputException | NumberFormatException e){
                System.out.println("Неправильный формат");
            }
        }
    }

    public Long inputLong(boolean nullable){
        while(true){
            var str = this.getLine();
            if(nullable && str.isEmpty()) return null;
            try{
                if(str.isEmpty()) throw new InvalidInputException("");
                return Long.parseLong(str);
            }catch(InvalidInputException | NumberFormatException e){
                System.out.println("Неправильный формат");
            }
        }
    }

    public Float inputFloat(boolean nullable){
        while(true){
            var str = this.getLine();
            if(nullable && str.isEmpty()) return null;
            try{
                if(str.isEmpty()) throw new InvalidInputException("");
                return Float.parseFloat(str);
            }catch(InvalidInputException | NumberFormatException e){
                System.out.println("Неправильный формат");
            }
        }
    }

    public Double inputDouble(boolean nullable){
        while(true){
            var str = this.getLine();
            if(nullable && str.isEmpty()) return null;
            try{
                if(str.isEmpty()) throw new InvalidInputException("");
                return Double.parseDouble(str);
            }catch(InvalidInputException | NumberFormatException e){
                System.out.println("Неправильный формат");
            }
        }
    }

    public String inputString(boolean nullable){
        while(true){
            var str = this.getLine();
            if(nullable && str.isEmpty()) return null;
            try{
                if(str.isEmpty()) throw new InvalidInputException("");
                return str;
            }catch(InvalidInputException e){
                System.out.println("Неправильный формат");
            }
        }
    }

    public Boolean inputBool(boolean nullable){
        while(true){
            var str = this.getLine();
            if(nullable && str.isEmpty()) return null;
            try{
                if(str.isEmpty()) throw new InvalidInputException("");
                return Boolean.parseBoolean(str);
            }catch(InvalidInputException e){
                System.out.println("Неправильный формат");
            }
        }
    }

    public Date inputDate(boolean nullable){
        while(true){
            var str = this.getLine();
            if(nullable && str.isEmpty()) return null;
            try{
                if(str.isEmpty()) throw new InvalidInputException("");
                SimpleDateFormat format = new SimpleDateFormat("dd.MM.yyyy");
                return format.parse(str);
            }catch(InvalidInputException | ParseException e){
                System.out.println("Неправильный формат");
            }
        }
    }

    public Color inputColor(boolean nullable){
        while(true){
            var str = this.getLine();
            if(nullable && str.isEmpty()) return null;
            try{
                if(str.isEmpty()) throw new InvalidInputException("");
                return Color.valueOf(str);
            }catch(InvalidInputException | IllegalArgumentException e){
                System.out.println("Неправильный формат");
            }
        }
    }

    public Country inputCountry(boolean nullable){
        while(true){
            var str = this.getLine();
            if(nullable && str.isEmpty()) return null;
            try{
                if(str.isEmpty()) throw new InvalidInputException("");
                return Country.valueOf(str);
            }catch(InvalidInputException | IllegalArgumentException e){
                System.out.println("Неправильный формат");
            }
        }
    }

    public Coordinates inputCoordinates(){
        float x;
        double y;
        System.out.print("Введите X : ");
        x = this.inputFloat(false);
        System.out.print("Введите Y (>-433) : ");
        while(true){
            try {
                y = this.inputDouble(false);
                if(y <=-433) throw new InvalidInputException("Число вне диапозона");
                break;
            }catch (InvalidInputException e){
                System.out.println(e.getMessage());
            }
        }
        return new Coordinates(x,y);
    }

    public Location inputLocation(boolean nullable){
        if(nullable){
            boolean flag;
            System.out.print("Поле не обязательно. Продолжить ввод? (true/false) : ");
            flag = this.inputBool(false);
            if(!flag) return null;
        }
        int x,y,z;
        String name;
        System.out.print("Введите X: ");
        x = this.inputInt(false);
        System.out.print("Введите Y: ");
        y = this.inputInt(false);
        System.out.print("Введите Z: ");
        z = this.inputInt(false);
        System.out.print("Введите name: ");
        name = this.inputString(false);
        return new Location(x,y,z,name);
    }

    public Person inputPerson(boolean nullable){
        if(nullable){
            boolean flag;
            System.out.print("Поле не обязательно. Продолжить ввод? (true/false) : ");
            flag = this.inputBool(false);
            if(!flag) return null;
        }
        String name,passportID;
        Country nationality;
        Location location;
        Date birthday;
        System.out.print("Введите name : ");
        name = this.inputString(false);
        System.out.print("Введите birthday (DD.MM.YYYY) : ");
        birthday = this.inputDate(false);
        System.out.print("Введите passportID : ");
        passportID = this.inputString(true);
        System.out.print("Введите nationality (необязательно) : [CHINA, INDIA, THAILAND, NORTH_KOREA] : ");
        nationality = this.inputCountry(true);
        System.out.print("Введите location (необязательно) : ");
        location = this.inputLocation(true);
        return new Person(name,birthday,passportID,nationality,location);
    }

    public Dragon inputDragon(){
        String name; //Поле не может быть null, Строка не может быть пустой
        Coordinates coordinates; //Поле не может быть null
        long age; //Значение поля должно быть больше 0
        Integer weight; //Значение поля должно быть больше 0, Поле может быть null
        Boolean speaking; //Поле не может быть null
        Color color; //Поле может быть null
        Person killer;
        System.out.print("Введите name : ");
        name = this.inputString(false);
        System.out.println("Введите coordinates : ");
        coordinates = this.inputCoordinates();
        while(true){
            System.out.print("Введите age (>0) : ");
            try{
                age = this.inputLong(false);
                if(age<=0) throw new InvalidInputException("");
                break;
            } catch (InvalidInputException e ) {
                System.out.println("Неверный формат");
            }
        }
        while(true){
            System.out.print("Введите weight (>0) (необязательное поле): ");
            weight = this.inputInt(true);
            if(weight == null) break;
            try{
                if(weight<=0) throw new InvalidInputException("");
                break;
            } catch (InvalidInputException e ) {
                System.out.println("Неверный формат");
            }
        }
        System.out.print("Введите speaking (false/true) : ");
        speaking = this.inputBool(false);
        System.out.print("Введите color (не обязательное поле) [GREEN, RED, BLACK, BLUE, YELLOW] : ");
        color = this.inputColor(true);
        System.out.print("Введите person (не обязательное поле) : ");
        killer = this.inputPerson(true);
        return new Dragon(-1 ,name,coordinates,new Date(),age,weight,speaking,color,killer);

    }

}
