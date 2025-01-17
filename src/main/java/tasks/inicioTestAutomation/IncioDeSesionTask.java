package tasks.inicioTestAutomation;

import interaction.esperaExplicita.EsperaExplicitaInteraction;
import net.serenitybdd.core.Serenity;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.matchers.WebElementStateMatchers;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static net.serenitybdd.screenplay.Tasks.instrumented;
import static userInterface.inicioTestAutomation.InicioDeSesionUI.*;
import static utilities.enums.EnumsID.REMEMBER_AMBIENTE;

public class IncioDeSesionTask implements Task {
    public static IncioDeSesionTask incioDeSesionTask() {
        return instrumented(IncioDeSesionTask.class);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        String ambiente = actor.recall(REMEMBER_AMBIENTE.toString());

        actor.attemptsTo(
                EsperaExplicitaInteraction.porSegundos(3),
                WaitUntil.the(TXT_EMAIL, WebElementStateMatchers.isVisible()).forNoMoreThan(30).seconds(),
                Enter.theValue(Serenity.environmentVariables().getProperty("environments." + ambiente + ".user")).into(TXT_EMAIL),
                Click.on(TXT_CONTRASENA1),
                EsperaExplicitaInteraction.porSegundos(2),
                Enter.theValue(Serenity.environmentVariables().getProperty("environments." + ambiente + ".password")).into(TXT_CONTRASENA1),
                Click.on(BTN_INGRESO)
        );
    }
}
