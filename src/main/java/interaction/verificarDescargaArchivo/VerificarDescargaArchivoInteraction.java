package interaction.verificarDescargaArchivo;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;


public class VerificarDescargaArchivoInteraction implements Interaction {

    private String rutaArchivo;

    public VerificarDescargaArchivoInteraction(String rutaArchivo) {
        this.rutaArchivo = rutaArchivo;
    }

    public static VerificarDescargaArchivoInteraction to(String rutaArchivo) {
        return new VerificarDescargaArchivoInteraction(rutaArchivo);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        Path path = Paths.get(rutaArchivo);
        if (!Files.exists(path)) {
            throw new AssertionError("El archivo no fue encontrado en la ruta esperada: " + rutaArchivo);
        }
    }
}
