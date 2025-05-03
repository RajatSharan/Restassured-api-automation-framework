package utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertyReader {

    public static String propertyReader(String filePath,String key) {

        try(InputStream in = new FileInputStream(filePath)){
            Properties prop = new Properties();
            prop.load(in);
            String value = prop.getProperty(key);
            if (value == null || value.trim().isEmpty()) {
                throw new IllegalArgumentException("Key '" + key + "' is missing or empty in file: " + filePath);
            }

            return value;

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
