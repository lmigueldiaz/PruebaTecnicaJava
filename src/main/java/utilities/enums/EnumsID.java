package utilities.enums;

public enum EnumsID {
    REMEMBER_VENTANAPRINCIPAL("Recodando el id"),
    REMEMBER_VALIDAR_TEXTO_QUESTION("Texto"),
    REMEMBER_AMBIENTE("Ambiente"),
    REMEMBER_INFO_DEL_ARCHIVO("fileContents"),
    REMEMBER_IDENTIFICACION("crearNoIdentificacion"),
    REMEMBER_NOMBRE("crearNombre"),
    REMEMBER_USUARIO("crearUsuario"),
    REMEMBER_TIPO_DOC_CONVERTIDO("tipoDocumentoConvertido"),
    REMEMBER_PATH("RutaDescarga"),
    ;


    private final String key;

    EnumsID(String key) {
        this.key = key;
    }

    @Override
    public String toString() { return key; }
}
