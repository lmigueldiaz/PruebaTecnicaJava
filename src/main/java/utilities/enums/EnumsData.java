package utilities.enums;

public enum EnumsData {
    REMEMBER_DATA_RADENTRADA("src/test/resources/data/ecm/"),
    REMEMBER_DATA_TIPO_TXT("src/test/resources/data/ecm/archivosTxt/"),
    REMEMBER_TESTING2("testing2"),
    REMEMBER_TESTING("testing.azure"),
    REMEMBER_SGDANORTE("sgdanorte"),
    REMEMBER_SDS("epxtestsds"),
    REMEMBER_PLANTILLA_EN_BLANCO("ecm-web-stykkhoahf3am.azurewebsites.net"),
    REMEMBER_AMBIENTE1("testing1"),
    REMEMBER_AMBIENTE2("testing2")
    ;

    private final String key;

    EnumsData(String key) {
        this.key = key;
    }

    @Override
    public String toString() {
        return key;
    }
}
