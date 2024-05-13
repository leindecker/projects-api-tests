package base.util;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import base.ProjectsSettings;
import base.RequestManager;

public class PropertieUtil {

    public static final String LOCAL_PROPERTY_FILE_NAME = "application-local.properties";
    public static final String DEFAULT_PROPERTY_FILE_NAME = "application.properties";

    BufferedReader reader;
    java.util.Properties properties = new java.util.Properties();

    public PropertieUtil() throws IOException {
        reader = new BufferedReader(new FileReader(ProjectsSettings.PROPERTIES_PATH + getFileName()));
        properties.load(reader);
    }

    public String getFileName() {
        if (RequestManager.shared().getProfile().equals("LOCAL")) {
            return LOCAL_PROPERTY_FILE_NAME;
        } else {
            return DEFAULT_PROPERTY_FILE_NAME;
        }
    }

    public String getPropertyByName(String property) {
        String propertyName = properties.getProperty(property);

        if (propertyName != null) {
            return propertyName;
        } else {
            throw new RuntimeException("Não foi encontrado a propriedade: " + property);
        }
    }
}
