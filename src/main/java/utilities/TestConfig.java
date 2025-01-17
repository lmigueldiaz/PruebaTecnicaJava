package utilities;

import java.util.Properties;

public class TestConfig {
private static final Properties properties = new Properties();

static {
    try {
        // Carga el archivo config.properties
        properties.load(TestConfig.class.getClassLoader().getResourceAsStream("config.properties"));

        // Sobrescribe con la propiedad del sistema si está presente
        String systemEnvironment = System.getProperty("environment");
        if (systemEnvironment != null && !systemEnvironment.isEmpty()) {
            properties.setProperty("environment", systemEnvironment);
        }
    } catch (Exception e) {
        throw new RuntimeException("Error al cargar la configuración de prueba", e);
    }
}

    public static String getEnvironment() {
        return properties.getProperty("environment");
    }

//    public static String getDownloadPath() {
//        // Aquí necesitas decidir cómo manejas múltiples entornos
//        String env = getEnvironment();
//        return properties.getProperty(env + ".download.path");
//    }
}