package com.yape.apitest.tasks;

import com.yape.apitest.conf.SessionVariables;
import com.yape.apitest.utils.Headers;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.rest.interactions.Patch;
import net.thucydides.core.annotations.Step;

import java.util.HashMap;
import java.util.Map;

public class ConsumOptionServicePatchBooking implements Task {

    public static ConsumOptionServicePatchBooking apiRest() {
        return Tasks.instrumented(ConsumOptionServicePatchBooking.class);
    }

    @Step("{0} enters consume api rest service")
    @Override
    public <T extends Actor> void performAs(T actor) {
        Map<String, String> headers = new HashMap<>();
        headers.put(Headers.CONTENT_TYPE.getKey(), Headers.CONTENT_TYPE.getValue());
        headers.put(Headers.ACCEPT.getKey(), Headers.ACCEPT.getValue());
        headers.put(Headers.AUTHORIZATION.getKey(), Headers.AUTHORIZATION.getValue());
        OnStage.theActorInTheSpotlight()
                .attemptsTo(
                        Patch.to((OnStage.theActorInTheSpotlight()
                                        .recall(SessionVariables.PATH.getKey())
                                        .toString()))
                                .with(
                                        request ->
                                                request
                                                        .headers(headers)
                                                        .body("{\"firstname\":\""
                                                                + (OnStage.theActorInTheSpotlight()
                                                                .recall(SessionVariables.FIRST_NAME.getKey())
                                                                .toString())
                                                                + "\",\"lastname\":\""
                                                                + (OnStage.theActorInTheSpotlight()
                                                                .recall(SessionVariables.LAST_NAME.getKey())
                                                                .toString())
                                                                + "\",\"additionalneedsopcional\":\""
                                                                + (OnStage.theActorInTheSpotlight()
                                                                .recall(SessionVariables.ADDITIONAL_NEEDS.getKey())
                                                                .toString()) + "\"}")));
    }
}
