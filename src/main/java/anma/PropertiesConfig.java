package anma;

import java.io.InputStream;
import java.util.Properties;

public class PropertiesConfig {

    public static final String DB_URL = "db.url";
    public static final String DB_LOGIN = "db.login";
    public static final String DB_PASSWORD = "db.password";

    private static final Properties properties = new Properties();

    public static String getProperty(String name, String DB) {
        if (properties.isEmpty()) {
            try (InputStream inputStream = PropertiesConfig.class.getClassLoader().getResourceAsStream(DB)) {
                properties.load(inputStream);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return properties.getProperty(name);
    }

}
