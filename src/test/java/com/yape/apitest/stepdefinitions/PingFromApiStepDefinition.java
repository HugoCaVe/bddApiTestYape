package com.yape.apitest.stepdefinitions;

import com.yape.apitest.conf.SessionVariables;
import com.yape.apitest.exceptions.ConsumOptionServicesException;
import com.yape.apitest.tasks.ConsumOptionServiceGetPing;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.actors.OnStage;

import static com.yape.apitest.utils.Constans.STATUS;
import static net.serenitybdd.rest.SerenityRest.lastResponse;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static net.serenitybdd.screenplay.rest.questions.ResponseConsequence.seeThatResponse;

public class PingFromApiStepDefinition {

    @Given("que ingresa el path (.*)$")
    public void userToEnterPathForPing(String path) {
        OnStage.theActorInTheSpotlight().remember(SessionVariables.PATH.getKey(), path);
    }

    @When("envía el servicio con los párametros para el diagnóstico")
    public void heConsultsTheInformationPing() {
        OnStage.theActorInTheSpotlight().attemptsTo(ConsumOptionServiceGetPing.apiRest());
    }

    @Then("se muestra la respuesta en el API (.*)$")
    public void bookingDeleteBooking(Integer code) {
        theActorInTheSpotlight()
                .should(
                        seeThatResponse(
                                STATUS ,response -> response.statusCode(code))
                                .orComplainWith(ConsumOptionServicesException.class, ConsumOptionServicesException.ERROR_RESPONSE_CODE));
        lastResponse().body().print();
    }
}
