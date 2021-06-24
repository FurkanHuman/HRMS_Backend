package io.kodlama.hrms.core.utilities.readProperty;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.springframework.context.annotation.Configuration;

@Configuration
public class ReadPropertFile {
    public static String propertiesPath;

    public String ReadPropert(String key) throws IOException {

        FileInputStream fileInputStream = new FileInputStream(propertiesPath);

        Properties properties = new Properties();

        properties.load(fileInputStream);
        return properties.getProperty(key).toString();
    }
}
