package com.yape.apitest.stepdefinitions;

import com.yape.apitest.conf.SessionVariables;
import com.yape.apitest.exceptions.ConsumOptionServicesException;
import com.yape.apitest.tasks.ConsumOptionServiceAuthPost;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.actors.OnStage;
import org.hamcrest.Matchers;

import static com.yape.apitest.utils.ExceptionsConstants.NO_TOKEN_INFORMATION_IS_DISPLAYED;
import static net.serenitybdd.rest.SerenityRest.lastResponse;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static net.serenitybdd.screenplay.rest.questions.ResponseConsequence.seeThatResponse;

public class AuthFromApiStepDefinition {

    @Given("que ingresa la información de las credenciales: Usuario (.*), contraseña (.*) y el path (.*)$")
    public void userToEnterTheCoordinateInformation(String userName, String password, String path) {
        OnStage.theActorInTheSpotlight().remember(SessionVariables.USER_NAME.getKey(), userName);
        OnStage.theActorInTheSpotlight().remember(SessionVariables.PASSWORD.getKey(), password);
        OnStage.theActorInTheSpotlight().remember(SessionVariables.PATH.getKey(), path);
    }

    @When("ejecuta el servicio con los párametros ingresados")
    public void heConsultsTheInformationPresentedAt() {
        OnStage.theActorInTheSpotlight().attemptsTo(ConsumOptionServiceAuthPost.apiRest());
    }

    @Then("se visualiza el token")
    public void locationInformationAndResponseCodeAreDisplayed() {
        theActorInTheSpotlight()
                .should(
                        seeThatResponse(
                                "Se muestra el token correspondiente: "
                                        + lastResponse().getBody().jsonPath().getJsonObject(""),
                                response -> response.body("token", Matchers.notNullValue()))
                                .orComplainWith(ConsumOptionServicesException.class, NO_TOKEN_INFORMATION_IS_DISPLAYED));
        OnStage.theActorInTheSpotlight().remember(SessionVariables.SESSION_TOKEN.getKey(), lastResponse().getBody().jsonPath().getJsonObject("token").toString());
        SerenityRest.lastResponse().body().print();
    }
}
