package utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class PropertyReader {

    Properties pro;
   PathHelper basePath;
    public PropertyReader(){
        pro= new Properties();
        basePath= new PathHelper();
        try {
            FileInputStream fis= new FileInputStream("C:\\intellijGenAi\\GenAi_New\\src\\main\\resources\\config.properties");
            try {
                pro.load(fis);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

    }

    public String getProperty(String key){
        return pro.getProperty(key);
    }
}
