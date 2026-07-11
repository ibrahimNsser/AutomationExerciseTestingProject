package data;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class LoadLoginHappyDataProperties {

    public static String path = System.getProperty("user.dir") + "\\src\\test\\java\\propertiesFiles\\loginHappydata.properties";

    public static Properties LoginHappyData = getLoginHappyData(path);

    private static Properties getLoginHappyData(String filePath) {
        Properties pro = new Properties(); 
        FileInputStream Stream = null; 
        
        try {
            Stream = new FileInputStream(filePath);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        
        try {
            pro.load(Stream); 
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        return pro; 
    }
}