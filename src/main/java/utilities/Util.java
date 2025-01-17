package utilities;
import net.thucydides.core.environment.SystemEnvironmentVariables;
import net.thucydides.core.util.EnvironmentVariables;

public class Util {
    public static String getDownloadPath() {
        EnvironmentVariables variables = SystemEnvironmentVariables.createEnvironmentVariables();

        String env = System.getProperty("environment", "default");
        String downloadPath = variables.getProperty(env + ".download.path");

        if (downloadPath == null) {
            System.out.println("No se encontró la propiedad 'download.path' para el entorno: " + env);
        }

        return downloadPath;
    }
}
