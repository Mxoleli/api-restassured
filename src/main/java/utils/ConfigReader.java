package utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {
    private static Properties properties = new Properties();

    static {
        try {
            FileInputStream fis = new FileInputStream("src/test/resources/config.properties");
            properties.load(fis);
            System.out.println("Config properties loaded successfully.");
        } catch (IOException e) {
            System.err.println("Failed to load config.properties: " + e.getMessage());
            e.printStackTrace();
            // You might want to throw a RuntimeException here to fail fast if config isn't found
            throw new RuntimeException("Could not load config.properties file.", e);
        }
    }

    public static String get(String key) {
        return properties.getProperty(key);
    }
}