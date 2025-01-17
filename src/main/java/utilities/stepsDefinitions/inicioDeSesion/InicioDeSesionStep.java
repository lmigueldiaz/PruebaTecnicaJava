package utilities.stepsDefinitions.inicioDeSesion;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import question.ValidarTextoQuestion;
import tasks.inicioTestAutomation.Browse;
import tasks.inicioTestAutomation.CerrarSesionTask;
import tasks.inicioTestAutomation.IncioDeSesionDatosFeatureTask;
import tasks.inicioTestAutomation.IncioDeSesionTask;
import utilities.BaseTemplate;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static org.hamcrest.CoreMatchers.equalTo;
import static userInterface.inicioTestAutomation.InicioDeSesionUI.*;

public class InicioDeSesionStep {

    BaseTemplate Data = new BaseTemplate();

    @Given("^Se ingresa a la url de test qa inlaze$")
    public void seIngresaALaUrlDeTestQaInlaze() {
        theActorInTheSpotlight().attemptsTo(Browse.openUrl());
    }

    @When("^Se ingresa usuario y contrasena$")
    public void seIngresaUsuarioContrasena() {
        theActorInTheSpotlight().attemptsTo(IncioDeSesionTask.incioDeSesionTask());
    }

    @When("^Se digita (.*) y (.*)$")
    public void seIngresaUsuarioContrasenaDesdeElFeature(String usuario, String contrasena) {
        Data.guardarDatos("usuario", String.valueOf(usuario));
        Data.guardarDatos("contrasena", String.valueOf(contrasena));
        theActorInTheSpotlight().attemptsTo(IncioDeSesionDatosFeatureTask.incioDeSesionDatosFeatureTask());
    }

    @Then("^Se valida el (.*) al iniciar sesion$")
    public void seValidaElMensajeDocumentosPendientes(String mensaje) {
        theActorInTheSpotlight().should(seeThat(ValidarTextoQuestion.validateText(TXT_WELCOME_LOREN), equalTo(mensaje)));
    }

    @Then("^Se valida el (.*) de usuario$")
    public void seValidaElNombreDeUsuario(String mensaje) {
        theActorInTheSpotlight().should(seeThat(ValidarTextoQuestion.validateText(TXT_VALIDATE_NOMBRE_USUARIO), equalTo(mensaje)));
    }

    @Then("^Se valida el (.*) datos erroneos$")
    public void seValidaElUsuarioOContrasenaIncorrectosDatosErrados(String mensajeSesionFallida) {
        theActorInTheSpotlight().should(seeThat(ValidarTextoQuestion.validateText(TXT_SESION_ERRADA), equalTo(mensajeSesionFallida)));
    }

    @Then("^Se cierra sesion$")
    public void seCierraSesion() {
        theActorInTheSpotlight().attemptsTo(CerrarSesionTask.cerrarSesion());
    }
}
