package configurations;

import com.google.common.base.Strings;

import java.net.URL;
import java.util.Properties;
import java.io.IOException;

public class ConfigInputData {

    private static Properties PROPERTIES = null;

    static {
        PROPERTIES = new Properties();
        URL propertyUrl = java.lang.ClassLoader.getSystemResource("inputData.properties");
        try{
            PROPERTIES.load(propertyUrl.openStream());
        }
        catch (IOException e){
            e.printStackTrace();
        }
    }

    public static String getProperty(String key) {
        return Strings.nullToEmpty(PROPERTIES.getProperty(key, null));
    }
}
