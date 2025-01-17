package userInterface.inicioTestAutomation;

import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.screenplay.targets.Target;

public class InicioDeSesionUI {

    public static final Target TXT_EMAIL = Target.the("Se ingresa el email para ingresar").located(By.xpath("//*[@id='email']"));
    public static final Target TXT_CONTRASENA1 = Target.the("Se ingresa la contraseña").located(By.xpath("//input[@id='password']"));
    public static final Target BTN_INGRESO = Target.the("Se da click en el boton ingreso").located(By.xpath("/html/body/app-root/app-sign-in/main/section[1]/app-sign-in-form/form/button"));
    public static final Target TXT_SESION_ERRADA = Target.the("Usuario o contraseña incorrectos").located(By.xpath("//div[@class='ml-3 text-sm font-normal']"));
    public static final Target BTN_PERFIL = Target.the("Boton Perfil").located(By.xpath("//img[@src='/assets/rengoku.webp']"));
    public static final Target BTN_LOGOUT = Target.the("Boton Perfil").located(By.xpath("/html/body/app-root/app-panel-root/app-navbar/div/div[2]/div/ul/li[3]/a"));
    public static final Target TXT_WELCOME_LOREN = Target.the("Titulo welcome to loren").located(By.xpath("/html/body/app-root/app-panel-root/main/section[1]/h2"));
    public static final Target TXT_VALIDATE_NOMBRE_USUARIO = Target.the("Usuario o contraseña incorrectos").located(By.xpath("//h2[@class='font-bold']"));
}
