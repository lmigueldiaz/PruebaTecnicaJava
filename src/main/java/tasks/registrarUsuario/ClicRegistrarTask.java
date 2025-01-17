package tasks.registrarUsuario;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.matchers.WebElementStateMatchers;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static net.serenitybdd.screenplay.Tasks.instrumented;
import static userInterface.registrarUsuario.RegistrarUsuarioUI.BTN_REGISTRO;

public class ClicRegistrarTask implements Task {
    public static ClicRegistrarTask clicRegistrar() {
        return instrumented(ClicRegistrarTask.class);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                WaitUntil.the(BTN_REGISTRO, WebElementStateMatchers.isClickable()).forNoMoreThan(10).seconds(),
                Click.on(BTN_REGISTRO)
        );
    }
}
