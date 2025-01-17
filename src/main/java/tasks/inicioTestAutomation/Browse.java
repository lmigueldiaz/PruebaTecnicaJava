package tasks.inicioTestAutomation;

import interaction.esperaExplicita.EsperaExplicitaInteraction;
import net.serenitybdd.core.Serenity;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Open;

import static net.serenitybdd.screenplay.Tasks.instrumented;
import static utilities.enums.EnumsID.REMEMBER_AMBIENTE;

public class Browse implements Task {

    public static Browse openUrl() {
        return instrumented(Browse.class);
    }
    @Override
    public <T extends Actor> void performAs(T actor) {

        String activeEnvironment = System.getProperty("environment");
        String baseUrl = Serenity.environmentVariables().getProperty("environments."+activeEnvironment+".webdriver.base.url");
        actor.remember(REMEMBER_AMBIENTE.toString(),activeEnvironment);

        actor.attemptsTo(
                EsperaExplicitaInteraction.porSegundos(3),
                Open.url(baseUrl)
        );
    }

}
