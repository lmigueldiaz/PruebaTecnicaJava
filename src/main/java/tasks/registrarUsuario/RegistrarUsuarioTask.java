package tasks.registrarUsuario;

import interaction.esperaExplicita.EsperaExplicitaInteraction;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.matchers.WebElementStateMatchers;
import net.serenitybdd.screenplay.waits.WaitUntil;
import utilities.BaseTemplate;

import static net.serenitybdd.screenplay.Tasks.instrumented;
import static userInterface.inicioTestAutomation.InicioDeSesionUI.BTN_INGRESO;
import static userInterface.inicioTestAutomation.InicioDeSesionUI.TXT_CONTRASENA1;
import static userInterface.registrarUsuario.RegistrarUsuarioUI.*;

public class RegistrarUsuarioTask implements Task {
    BaseTemplate data = new BaseTemplate();

    public static RegistrarUsuarioTask registrarUsuario() {
        return instrumented(RegistrarUsuarioTask.class);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {

        actor.attemptsTo(
                WaitUntil.the(TXT_NOMBRE_USUARIO, WebElementStateMatchers.isVisible()).forNoMoreThan(10).seconds(),
                Enter.theValue(data.obtenerDatos("name")).into(TXT_NOMBRE_USUARIO),
                EsperaExplicitaInteraction.porSegundos(1),
                WaitUntil.the(TXT_EMAIL, WebElementStateMatchers.isVisible()).forNoMoreThan(10).seconds(),
                Enter.theValue(data.obtenerDatos("email")).into(TXT_EMAIL),
                Click.on(TXT_CONTRASENA1),
                EsperaExplicitaInteraction.porSegundos(1),
                Enter.theValue(data.obtenerDatos("password")).into(TXT_CONTRASENA1),
                EsperaExplicitaInteraction.porSegundos(1),
                Enter.theValue(data.obtenerDatos("rememberPassword")).into(TXT_REMEMBER_CONTRASENA)
        );
    }
}
