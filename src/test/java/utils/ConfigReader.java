package utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {
    static Properties prop;

    public static Properties readProperties(String filePath){
        try {
            //navigate  the file
            FileInputStream fis = new FileInputStream(filePath);
            //special class that can load/handle  the files.
            prop = new Properties();
            //load all the data from the file which we mentioned inside(" ") and store inside the prop.
            prop.load(fis);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return prop;
    }

    public static String getPropertyValue(String key){ //this  method will provide properties value based on the key we passed on the parameters.
        //get property is the method which will read the value as per the key provided
        return prop.getProperty(key);//note as we know the prop carry all the data , so from that data we are getting specific data which we are requesting for with the help of getProperty() method.
    }

}
