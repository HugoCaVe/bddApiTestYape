package com.yape.apitest.tasks;

import com.yape.apitest.conf.SessionVariables;
import com.yape.apitest.utils.Headers;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.rest.interactions.Delete;
import net.thucydides.core.annotations.Step;

public class ConsumOptionServiceDeleteBooking implements Task {

    public static ConsumOptionServiceDeleteBooking apiRest() {
        return Tasks.instrumented(ConsumOptionServiceDeleteBooking.class);
    }

    @Step("{0} enters consume api rest service")
    @Override
    public <T extends Actor> void performAs(T actor) {
        OnStage.theActorInTheSpotlight()
                .attemptsTo(
                        Delete.from((OnStage.theActorInTheSpotlight()
                                        .recall(SessionVariables.PATH.getKey())
                                        .toString()))
                                .with(
                                        request ->
                                                request
                                                        .headers(Headers.AUTHORIZATION.getKey(), Headers.AUTHORIZATION.getValue())));
    }
}