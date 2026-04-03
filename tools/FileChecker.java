package tools;

import java.io.File;

public class FileChecker {
    public static boolean check(String path){
        File file = new File(path);
        return file.exists() && file.isFile() && file.canWrite() && file.canRead();
    }
}
