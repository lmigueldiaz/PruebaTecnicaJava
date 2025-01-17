package utilities.stepsDefinitions.registrarUsuario;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import question.ValidarTextoQuestion;
import tasks.registrarUsuario.ClicBotonSignInTask;
import tasks.registrarUsuario.ClicRegistrarTask;
import tasks.registrarUsuario.RegistrarUsuarioTask;
import utilities.BaseTemplate;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static org.hamcrest.CoreMatchers.equalTo;
import static userInterface.registrarUsuario.RegistrarUsuarioUI.MSJ_REGISTRO_EXITOSO;
import static userInterface.registrarUsuario.RegistrarUsuarioUI.MSJ_REGISTRO_FALLIDO;

public class RegistrarUsuarioStep {

    BaseTemplate Data = new BaseTemplate();

    @When("^Se ingresa al registro$")
    public void seIngresaAlRegistro() {
        theActorInTheSpotlight().attemptsTo(ClicRegistrarTask.clicRegistrar());
    }

    @When("^Se digitan los datos del registro name (.*) email (.*) pass (.*) rememberPass (.*)$")
    public void seDigitanLosDatosRegistro(String name, String email, String password, String rememberPassword) {
        Data.guardarDatos("name", String.valueOf(name));
        Data.guardarDatos("email", String.valueOf(email));
        Data.guardarDatos("password", String.valueOf(password));
        Data.guardarDatos("rememberPassword", String.valueOf(rememberPassword));
        theActorInTheSpotlight().attemptsTo(RegistrarUsuarioTask.registrarUsuario());
    }

    @When("^Clic boton registrar$")
    public void clicBotonRegistrar() {
        theActorInTheSpotlight().attemptsTo(ClicBotonSignInTask.clicBotonSignIn());
    }

    @Then("^Se valida (.*) registro exitoso$")
    public void seValidaRegistroExitoso(String mensajeRegistroExitoso) {
        theActorInTheSpotlight().should(seeThat(ValidarTextoQuestion.validateText(MSJ_REGISTRO_EXITOSO), equalTo(mensajeRegistroExitoso)));
    }

    @Then("^Se valida (.*) registro fallido")
    public void seValidaRegistroFallido(String mensajeRegistroExitoso) {
        theActorInTheSpotlight().should(seeThat(ValidarTextoQuestion.validateText(MSJ_REGISTRO_FALLIDO), equalTo(mensajeRegistroExitoso)));
    }
}
