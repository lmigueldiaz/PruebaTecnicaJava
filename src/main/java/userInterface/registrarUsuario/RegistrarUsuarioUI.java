package userInterface.registrarUsuario;

import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.screenplay.targets.Target;

public class RegistrarUsuarioUI {

    public static final Target BTN_REGISTRO = Target.the("Boton Registro").located(By.xpath("//a[@href='/auth/sign-up']"));
    public static final Target TXT_NOMBRE_USUARIO = Target.the("Se ingresa el nombre del usuario para ingresar").located(By.xpath("//*[@id='full-name']"));
    public static final Target TXT_EMAIL = Target.the("Se ingresa el email para ingresar").located(By.xpath("//*[@id='email']"));
    public static final Target TXT_REMEMBER_CONTRASENA = Target.the("Se ingresa el email para ingresar").located(By.xpath("//input[@id='confirm-password']"));
    public static final Target BTN_SIGN_UP = Target.the("Se da click en el boton registro").located(By.xpath("//button[@type='submit']"));
    public static final Target MSJ_REGISTRO_EXITOSO = Target.the("Registro Exitoso").located(By.xpath("//div[@class='ml-3 text-sm font-normal']"));
    public static final Target MSJ_REGISTRO_FALLIDO = Target.the("Registro Fallido").located(By.xpath("/html/body/app-root/app-sign-up/main/section[2]/app-sign-up-form/form/div[4]/label[2]/span"));
}

