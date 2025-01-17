package tasks.inicioTestAutomation;

import interaction.esperaExplicita.EsperaExplicitaInteraction;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.matchers.WebElementStateMatchers;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static net.serenitybdd.screenplay.Tasks.instrumented;
import static userInterface.inicioTestAutomation.InicioDeSesionUI.BTN_LOGOUT;
import static userInterface.inicioTestAutomation.InicioDeSesionUI.BTN_PERFIL;

public class CerrarSesionTask implements Task {
    public static CerrarSesionTask cerrarSesion() {
        return instrumented(CerrarSesionTask.class);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {

        actor.attemptsTo(
                EsperaExplicitaInteraction.porSegundos(2),
                WaitUntil.the(BTN_PERFIL, WebElementStateMatchers.isVisible()).forNoMoreThan(30).seconds(),
                Click.on(BTN_PERFIL),
                EsperaExplicitaInteraction.porSegundos(2),
                WaitUntil.the(BTN_LOGOUT, WebElementStateMatchers.isVisible()).forNoMoreThan(30).seconds(),
                Click.on(BTN_LOGOUT)
        );
    }
}
