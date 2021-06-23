package io.kodlama.hrms.core.utilities.readProperty;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.springframework.beans.factory.annotation.Autowired;

public class ReadPropertFile {

    private static String propertiesPath;

    @Autowired
    public ReadPropertFile(String propertiesPath) throws FileNotFoundException, IOException {

    }

    public Properties ReadPropert() throws IOException {

        FileInputStream fileInputStream = new FileInputStream(propertiesPath);

        Properties properties = new Properties();

        properties.load(fileInputStream);
        return properties;
    }
}
