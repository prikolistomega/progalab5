package tools;

import java.io.*;

public class Reader {
    private BufferedReader inputReader;
    private String scriptPath;

    public Reader(){
        inputReader = new BufferedReader(new InputStreamReader(System.in));
    }

    public Reader(String scriptPath) throws FileNotFoundException {
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
}
