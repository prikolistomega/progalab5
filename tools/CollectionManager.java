package tools;

import commands.*;
import exceptions.EmptyDequeException;
import exceptions.InvalidInputException;
import exceptions.RecursionLimitException;
import exceptions.XmlSaveException;
import main_classes.ApplicationContext;
import models.Dragon;

import java.io.FileNotFoundException;
import java.util.*;


public class CollectionManager {
    private InputManager inputManager;
    private ArrayDeque<Dragon> collection;
    private HashMap<String, Command> commands;

    {
        commands = new HashMap<String,Command>();
        commands.put("help",new Help(this));
        commands.put("info",new Info(this));
        commands.put("show",new Show(this));
        commands.put("add",new Add(this));
        commands.put("update",new Update(this));
        commands.put("remove_by_id",new RemoveById(this));
        commands.put("clear",new Clear(this));
        commands.put("save",new Save(this));
        commands.put("execute_script",new ExecuteScript(this));
        commands.put("exit",new Exit(this));
        commands.put("remove_head",new RemoveHead(this));
        commands.put("add_if_max",new AddIfMax(this));
        commands.put("add_if_min",new AddIfMin(this));
        commands.put("average_of_age",new AverageOfAge(this));
        commands.put("filter_less_than_age",new FilterLessThanAge(this));
        commands.put("print_unique_speaking",new PrintUniqueWeight(this));
    }

    public CollectionManager(InputManager inputManager, ArrayDeque<Dragon> collection){
        this.inputManager = inputManager;
        this.collection = collection;
    }

    public void startManage(){
        while (true){
            try {
                var str = inputManager.getLine();
                if(str==null) break;
                String[] splittedStr = str.split(" ");
                if(splittedStr.length ==0) throw new InvalidInputException("Неверный формат");
                Command command = commands.get(splittedStr[0]);
                if(splittedStr.length>1) command.setArg(splittedStr[1]);
                command.execute();
                command.setArg(null);
            }catch (InvalidInputException e){
                System.out.println(e.getMessage());
            }

        }
    }

    public void add(){
        Dragon elem = inputManager.inputDragon();
        elem.setId(getMaxId()+1);
        collection.addLast(elem);
        System.out.println("Элемент добавлен");
    }

    public void addIfMax(){
        var newDragon = inputManager.inputDragon();
        newDragon.setId(getMaxId()+1);
        Boolean isMax = true;
        for(var elem : collection){
            if( newDragon.compareTo(elem) <0) isMax = false;
        }
        if(isMax){
            collection.addLast(newDragon);
            System.out.println("Элемент добавлен");
        }else {
            System.out.println("Элемент не максимальный");
        }
    }

    public void addIfMin(){
        var newDragon = inputManager.inputDragon();
        newDragon.setId(getMaxId()+1);
        Boolean isMin = true;
        for(var elem : collection){
            if( newDragon.compareTo(elem) >0) isMin = false;
        }
        if(isMin){
            collection.addLast(newDragon);
            System.out.println("Элемент добавлен");
        }else {
            System.out.println("Элемент не минимальный");
        }
    }

    public void averageOfAge(){
        try {
            if(collection.isEmpty()) throw new EmptyDequeException("Коллекция пуста");
            Float sum = 0F;
            for(var elem : collection){
                sum+= (float) elem.getAge();
            }
            Float average = sum/(float)collection.size();
            System.out.println(average);
        }catch (EmptyDequeException e){
            System.out.println(e.getMessage());
        }
    }

    public void clear(){
        collection.clear();
        System.out.println("Коллекция очищена");
    }

    public void executeScript(String path){
        try {
            if (ExecuteScript.runningScripts >100) throw new RecursionLimitException("Превышен предел рекурсии");
            InputManager reader = new InputManager(path);
            CollectionManager manager = new CollectionManager(reader,collection);
            ExecuteScript.runningScripts +=1;
            manager.startManage();
            ExecuteScript.runningScripts -=1;
        } catch (FileNotFoundException e) {
            System.out.println("Файл не найден");
        }catch (RecursionLimitException e){
            System.out.println(e.getMessage());
        }
    }

    public void exit(){
        System.exit(0);
    }

    public void filterLessThanAge(long age){
        String filtredCollection = "";
        for(var elem : collection){
            if(elem.getAge()<age) filtredCollection+=elem.toString();
        }
        System.out.println(filtredCollection);
    }

    public void help(){
        String helpMessage = """
                Доступные команды:
                
                help - вывести справку по доступным командам
                info - вывести информацию о коллекции
                show - вывести все элементы коллекции
                add - добавить новый элемент в коллекцию
                update id - обновить значение элемента, id которого равен заданному 
                remove_by_id id - удалить элемент по id
                clear - очистить коллекцию
                save - сохранить коллекцию в файл
                execute_script file_name - считать и исполнить скрипт из указанного файла
                exit - завершить программу
                remove_head - вывести первый элемент коллекции и удалить его
                add_if_max - добавить новый элемент в коллекцию, если его значение превышает значение наибольшего элемента этой коллекции
                add_if_min - добавить новый элемент в коллекцию, если его значение меньше, чем у наименьшего элемента этой коллекции
                average_of_age - вывести среднее значение поля age для всех элементов коллекции
                filter_less_than_age age - вывести элементы, значение поля age которых меньше заданного
                print_unique_weight - вывести уникальные значения поля weight всех элементов в коллекции
                """;
        System.out.println(helpMessage);
    }

    public void info(){
        String info = String.format("""
                Информация о коллекции:
                
                Тип: ArrayDeque
                Дата инициализации: %s
                Количество элементов: %d
                """, ApplicationContext.creationTime,collection.size());
        System.out.println(info);
    }

    public void printUniqueWeight(){
        HashSet<Integer> set = new HashSet<>();
        for(var elem: collection){
            set.add(elem.getWeight());
        }
        System.out.println(set.toString());
    }

    public void removeById(long id){
        for(var elem : collection){
            if(elem.getId() == id){
                collection.remove(elem);
                System.out.println("Элемент удалён");
                return;
            }
        }
        System.out.println("Элемент не найден");
    }

    public void removeHead(){
        try {
            if(collection.isEmpty()) throw new EmptyDequeException("Коллекция пуста");
           System.out.println(collection.poll().toString());
        } catch (EmptyDequeException e) {
            System.out.println(e.getMessage());
        }
    }

    public void save(){
        XMLWriter xmlWriter = new XMLWriter();
        try {
            xmlWriter.toXML(collection);
            System.out.println("Запись файла прошла успешно");
        }catch (XmlSaveException e){
            System.out.println(e.getMessage());
        }
    }

    public void show(){
        for(var elem : collection){
            System.out.println(elem);
        }
    }

    public void update(long id){
        var updDragon = inputManager.inputDragon();
        Dragon[] array = collection.toArray(new Dragon[0]);
        for(int i =0;i< array.length;i++){
            if(array[i].getId() == id){
                Date date = array[i].getCreationDate();
                array[i] = updDragon;
                array[i].setId(id);
                array[i].setCreationDate(date);
                collection = new ArrayDeque<>(Arrays.asList(array));
                System.out.println("Элемент обновлён");
                return;
            }
        }
        System.out.println("Элемент не найден");
    }

    public long getMaxId(){
        long id = 1;
        for(var e : collection){
            id = Math.max(id,e.getId());
        }
        return id;
    }
}
