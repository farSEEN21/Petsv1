package org.example.utils;

import org.example.dto.Sex;
import org.example.dto.Type;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class Reader {

    static Properties properties = new Properties();

    public static String getProperty(String param) {
        if (properties.toString().equals("{}")) {
            initProperty();
        }
        return properties.getProperty(param);
    }

    private static void initProperty() {
        try (FileReader fileReader = new FileReader("src/main/resources/locators.property")) {
            properties.load(fileReader);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public static String getProperty(Type param) {
        if (properties.toString().equals("{}")) {
            initProperty();
        }
        return properties.getProperty(String.valueOf(param));
    }

    public static String getProperty(Sex param) {
        if (properties.toString().equals("{}")) {
            initProperty();
        }
        return properties.getProperty(String.valueOf(param));
    }


}
