package Hooks;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import net.serenitybdd.core.Serenity;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import org.openqa.selenium.WebDriver;
import utilities.TestConfig;

import java.util.Set;

import static net.serenitybdd.screenplay.actors.OnStage.theActorCalled;

public class Testclean {

    @Before
    public void setupEnvironment() {
        OnStage.setTheStage(new OnlineCast());
        theActorCalled("actor");
        System.setProperty("environment", TestConfig.getEnvironment());

    }

    @After
    public void tearDown() {
        Serenity.getWebdriverManager().closeCurrentDrivers();

        WebDriver driver = Serenity.getDriver();
        if (driver != null) {

            try {
                // Obtener todas las ventanas abiertas
                Set<String> allWindowHandles = driver.getWindowHandles();

                // Cerrar todas las ventanas y eliminar cookies
                for (String windowHandle : allWindowHandles) {
                    driver.switchTo().window(windowHandle);
                    driver.manage().deleteAllCookies();
                    driver.close();
                }

                // Finalmente, cierra el navegador
                driver.quit();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        System.out.println("Ejecutando Hook After");
    }
}
