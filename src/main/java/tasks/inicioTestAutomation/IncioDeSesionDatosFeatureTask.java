package tasks.inicioTestAutomation;

import interaction.esperaExplicita.EsperaExplicitaInteraction;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.matchers.WebElementStateMatchers;
import net.serenitybdd.screenplay.waits.WaitUntil;
import utilities.BaseTemplate;

import static net.serenitybdd.screenplay.Tasks.instrumented;
import static userInterface.inicioTestAutomation.InicioDeSesionUI.*;

public class IncioDeSesionDatosFeatureTask implements Task {
    BaseTemplate data = new BaseTemplate();

    public static IncioDeSesionDatosFeatureTask incioDeSesionDatosFeatureTask() {
        return instrumented(IncioDeSesionDatosFeatureTask.class);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {

        actor.attemptsTo(
                WaitUntil.the(TXT_EMAIL, WebElementStateMatchers.isVisible()).forNoMoreThan(100).seconds(),
                EsperaExplicitaInteraction.porSegundos(1),
                Enter.theValue(data.obtenerDatos("usuario")).into(TXT_EMAIL),
                EsperaExplicitaInteraction.porSegundos(1),
                Click.on(TXT_CONTRASENA1),
                EsperaExplicitaInteraction.porSegundos(1),
                Enter.theValue(data.obtenerDatos("contrasena")).into(TXT_CONTRASENA1),
                Click.on(BTN_INGRESO)
        );
    }
}
