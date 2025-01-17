package tasks.registrarUsuario;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.matchers.WebElementStateMatchers;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static net.serenitybdd.screenplay.Tasks.instrumented;
import static userInterface.registrarUsuario.RegistrarUsuarioUI.BTN_SIGN_UP;

public class ClicBotonSignInTask implements Task {
    public static ClicBotonSignInTask clicBotonSignIn() {
        return instrumented(ClicBotonSignInTask.class);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                WaitUntil.the(BTN_SIGN_UP, WebElementStateMatchers.isClickable()).forNoMoreThan(10).seconds(),
                Click.on(BTN_SIGN_UP)
        );
    }
}
