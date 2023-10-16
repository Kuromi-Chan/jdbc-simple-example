package org.example.utils;

import java.io.IOException;
import java.util.Properties;

public final class PropertiesUtil {
    public static final Properties PROPERTIES = new Properties();
    static{
        loadProperties();
    }

    public static String get(String key){
        return (String) PROPERTIES.get(key);
    }
    private static void loadProperties() {

        try (var inputStrean = PropertiesUtil.class.getClassLoader().getResourceAsStream("application.properties")) {
            PROPERTIES.load(inputStrean);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }
}
