package proje.utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {
    static Properties properties;

    static {
        try {
            FileInputStream fis = new FileInputStream("configuration.properties");
            properties = new Properties();
            properties.load(fis);//-->fis'in okuduğu bilgileri properties'e yükler
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static String getProperty(String key) {

        return properties.getProperty(key);//-->String olarak girdiğim key'in değerini return eder
    }
}
