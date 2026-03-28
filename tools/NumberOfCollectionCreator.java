package tools;

import java.io.File;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class NumberOfCollectionCreator {
    public static int getNumb(){
        int numb = 0;
        File[] dir = (new File("./")).listFiles();
        Pattern pattern = Pattern.compile("collection(\\d+).xml");
        StringBuilder str = new StringBuilder();
        Matcher matcher;
        for(File f : dir){
            matcher = pattern.matcher(f.getName());
            if(matcher.find()) numb = Math.max(numb,Integer.parseInt(matcher.group(1)));
        }
        return numb+1;



    }
}
