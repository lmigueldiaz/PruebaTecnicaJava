package question;

import interaction.esperaExplicita.EsperaExplicitaInteraction;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.matchers.WebElementStateMatchers;
import net.serenitybdd.screenplay.questions.Text;
import net.serenitybdd.screenplay.targets.Target;
import net.serenitybdd.screenplay.waits.WaitUntil;

import java.util.logging.Logger;


public class ValidarTextoQuestion implements Question<String> {

    private static final Logger LOGGER = Logger.getLogger(String.valueOf(ValidarTextoQuestion.class));
    Target element;

    public ValidarTextoQuestion(Target element) {
        this.element = element;
    }

    public static ValidarTextoQuestion validateText(Target element) {
        return new ValidarTextoQuestion(element);

    }

    @Override
    public String answeredBy(Actor actor) {

        try {
            actor.attemptsTo(
                    WaitUntil.the(element, WebElementStateMatchers.isPresent()).forNoMoreThan(10).seconds(),
                    EsperaExplicitaInteraction.porSegundos(2)
            );
        }  catch (Exception e) {
            throw new RuntimeException("El elemento no está presente: " + element.getName(), e);
        }

        String labelField = Text.of(element).answeredBy (actor).toString().split("\n")[0];
        LOGGER.info("El texto encontrado en el localizador es: " + labelField);
        return labelField;
    }
}
