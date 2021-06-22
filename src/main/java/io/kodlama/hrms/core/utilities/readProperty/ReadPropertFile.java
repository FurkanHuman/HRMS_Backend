package io.kodlama.hrms.core.utilities.readProperty;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ReadPropertFile {

    private static String propertiesPath;

    public ReadPropertFile(String propertiesPath) throws FileNotFoundException, IOException {

    }

    public Properties ReadPropert() throws IOException {

        FileInputStream fileInputStream = new FileInputStream(propertiesPath);

        Properties properties = new Properties();

        properties.load(fileInputStream);
        return properties;
    }
}
