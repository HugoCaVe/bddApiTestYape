package com.yape.apitest.stepdefinitions;

import com.yape.apitest.conf.SessionVariables;
import com.yape.apitest.exceptions.ConsumOptionServicesException;
import com.yape.apitest.questions.ValidateLastResponse;
import com.yape.apitest.tasks.*;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.actors.OnStage;
import org.hamcrest.Matchers;


import static com.yape.apitest.conf.SessionVariables.*;
import static com.yape.apitest.utils.Constans.*;
import static net.serenitybdd.rest.SerenityRest.lastResponse;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static net.serenitybdd.screenplay.rest.questions.ResponseConsequence.seeThatResponse;

public class BookingFromApiStepDefinition {

    @Given("que ingresa la información para la reserva: Nombre (.*) y el Apellido (.*)$")
    public void userToEnterPersonalInformation(String firtName, String lastName) {
        OnStage.theActorInTheSpotlight().remember(SessionVariables.FIRST_NAME.getKey(), firtName);
        OnStage.theActorInTheSpotlight().remember(SessionVariables.LAST_NAME.getKey(), lastName);
    }

    @Given("que ingresa la información de los costos: Precio Total (.*), Depósito abonado (.*)$")
    public void userToEnterPriceInformation(Integer totalPrice, Boolean depositePaid) {
        OnStage.theActorInTheSpotlight().remember(SessionVariables.TOTAL_PRICE.getKey(), totalPrice);
        OnStage.theActorInTheSpotlight().remember(SessionVariables.DEPOSIT_PAID.getKey(), depositePaid);
    }

    @Given("que ingresa la información de las fechas de reserva: Fecha de llegada (.*), Fecha de Salida (.*)$")
    public void userToEnterDateInformation(String checkin, String checkout) {
        OnStage.theActorInTheSpotlight().remember(SessionVariables.START_DATE.getKey(), checkin);
        OnStage.theActorInTheSpotlight().remember(SessionVariables.END_DATE.getKey(), checkout);
    }

    @Given("que ingresa solicitudes adicionales: (.*)$")
    public void userToEnterAdditionalNeedsInformation(String needs) {
        OnStage.theActorInTheSpotlight().remember(SessionVariables.ADDITIONAL_NEEDS.getKey(), needs);
    }

    @Given("que ingresa el path: (.*)$")
    public void userToEnterPathInformation(String path) {
        OnStage.theActorInTheSpotlight().remember(SessionVariables.PATH.getKey(), path);
    }

    @Given("que filtra la búsqueda por Nombre (.*) y Apellido (.*)$")
    public void userFilterPersonalInformation(String fisrtName, String lastName) {
        if(!fisrtName.equals(NOT_APPLY)){
            OnStage.theActorInTheSpotlight().remember(SessionVariables.FILTER_PERSONAL_INFORMATION.getKey(), (FILTER_FIRST_NAME_PARAMETER.getKey() + fisrtName + FILTER_LAST_NAME_PARAMETER.getKey() + lastName));
        } else {
            OnStage.theActorInTheSpotlight().remember(SessionVariables.FILTER_PERSONAL_INFORMATION.getKey(), "");
        }
    }

    @Given("por fecha de ingreso (.*) y fecha de salida (.*)$")
    public void userFilterAdditionallInformation(String checkin, String checkout) {
        if(!checkin.equals(NOT_APPLY)) {
            OnStage.theActorInTheSpotlight().remember(SessionVariables.FILTER_DATE_INFORMATION.getKey(), (FILTER_CHECKIN_PARAMETER.getKey() + checkin + FILTER_CHECKOUT_PARAMETER.getKey() + checkout));
        } else {
            OnStage.theActorInTheSpotlight().remember(SessionVariables.FILTER_DATE_INFORMATION.getKey(), "");
        }
    }

    @Given("que realiza la búsqueda por el identificador de la reserva (.*)$")
    public void userFilterBookingIdAndPath(Integer bookingId) {
        OnStage.theActorInTheSpotlight().remember(SessionVariables.PATH.getKey(), (PATH_BOOKING + bookingId));
        OnStage.theActorInTheSpotlight().remember(SessionVariables.FILTER_DATE_INFORMATION.getKey(), "");
        OnStage.theActorInTheSpotlight().remember(SessionVariables.FILTER_PERSONAL_INFORMATION.getKey(), "");
    }

    @Given("que se ingresa el identificador de la reserva (.*)$")
    public void userFilterBookingId(Integer bookingId) {
        OnStage.theActorInTheSpotlight().remember(SessionVariables.PATH.getKey(), (PATH_BOOKING + bookingId));
    }

    @When("ejecuta el servicio con la información necesaria para la reserva")
    public void heConsultsTheInformationPresentedAt() {
        OnStage.theActorInTheSpotlight().attemptsTo(ConsumOptionServiceBookingPost.apiRest());
    }

    @When("ejecuta el servicio con los parámetros de reserva enviados")
    public void heConsultsTheBookingIdsInformation() {
        OnStage.theActorInTheSpotlight().attemptsTo(ConsumOptionServiceGetBooking.apiRest());
    }

    @When("ejecuta el servicio para modificar las reservas con los parámetros ingresados")
    public void heUpdateTheBooking() {
        OnStage.theActorInTheSpotlight().attemptsTo(ConsumOptionServicePutBooking.apiRest());
    }

    @When("ejecuta el servicio para modificar parcialmente la reserva")
    public void heUpdateEspecificDataTheBooking() {
        OnStage.theActorInTheSpotlight().attemptsTo(ConsumOptionServicePatchBooking.apiRest());
    }

    @When("ejecuta el servicio para borrar el registro")
    public void heDeleteTheBookingForId() {
        OnStage.theActorInTheSpotlight().attemptsTo(ConsumOptionServiceDeleteBooking.apiRest());
    }

    @Then("se genera una reserva")
    public void bookingInformationAndResponseCodeAreDisplayed() {
        theActorInTheSpotlight()
                .should(
                        seeThatResponse(
                                BOOKING_INFORMATION
                                        + lastResponse().getBody().jsonPath().getJsonObject(""),
                                response -> response.body(BOOKING_ID, Matchers.notNullValue()))
                                .orComplainWith(ConsumOptionServicesException.class, ConsumOptionServicesException.ERROR_VALIDATION));
        OnStage.theActorInTheSpotlight().remember(SessionVariables.SESSION_TOKEN.getKey(), lastResponse().getBody().jsonPath().getJsonObject(BOOKING_ID).toString());
        SerenityRest.lastResponse().body().print();
    }

    @Then("se muestra los Ids de las reservas disponibles")
    public void bookingIdsInformationResponse() {
        theActorInTheSpotlight()
                .should(
                        seeThatResponse(
                                BOOKING_INFORMATION_IDS
                                        + lastResponse().getBody().jsonPath().getJsonObject(""),
                                response -> response.body(BOOKING_ID, Matchers.notNullValue()))
                                .orComplainWith(ConsumOptionServicesException.class, ConsumOptionServicesException.ERROR_VALIDATION));
        OnStage.theActorInTheSpotlight().remember(SessionVariables.SESSION_TOKEN.getKey(), lastResponse().getBody().jsonPath().getJsonObject(BOOKING_ID).toString());
        SerenityRest.lastResponse().body().print();
    }

    @Then("se muestra la información de la reserva")
    public void bookingInformationForIdResponse() {
        theActorInTheSpotlight()
                .should(
                        seeThatResponse(
                                STATUS ,response -> response.statusCode(RESPONSE_CODE))
                                .orComplainWith(ConsumOptionServicesException.class, ConsumOptionServicesException.ERROR_RESPONSE_CODE),
                        seeThat(
                                ValidateLastResponse.forResource(), Matchers.notNullValue()).orComplainWith(ConsumOptionServicesException.class, ConsumOptionServicesException.ERROR_VALIDATION));
        lastResponse().body().print();
    }

    @Then("se actualiza la información de la reserva")
    public void bookingUpdateInformationForIdResponse() {
        theActorInTheSpotlight()
                .should(
                        seeThatResponse(
                                STATUS ,response -> response.statusCode(RESPONSE_CODE))
                                .orComplainWith(ConsumOptionServicesException.class, ConsumOptionServicesException.ERROR_RESPONSE_CODE),
                        seeThat(
                                ValidateLastResponse.forResource(), Matchers.notNullValue()).orComplainWith(ConsumOptionServicesException.class, ConsumOptionServicesException.ERROR_VALIDATION));
        lastResponse().body().print();
    }

    @Then("se elimina el registro y la información de la reserva")
    public void bookingDeleteBooking() {
        theActorInTheSpotlight()
                .should(
                        seeThatResponse(
                                STATUS ,response -> response.statusCode(RESPONSE_CODE_OTHER))
                                .orComplainWith(ConsumOptionServicesException.class, ConsumOptionServicesException.ERROR_RESPONSE_CODE));
        lastResponse().body().print();
    }
}