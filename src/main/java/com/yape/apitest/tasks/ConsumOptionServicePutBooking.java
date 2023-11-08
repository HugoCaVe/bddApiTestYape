package com.yape.apitest.tasks;

import com.yape.apitest.conf.SessionVariables;
import com.yape.apitest.models.Booking;
import com.yape.apitest.models.Bookingdates;
import com.yape.apitest.utils.Headers;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.rest.interactions.Put;
import net.thucydides.core.annotations.Step;

import java.util.HashMap;
import java.util.Map;

public class ConsumOptionServicePutBooking implements Task {
    Booking booking;
    Bookingdates bookingdates;
    public static ConsumOptionServicePutBooking apiRest() {
        return Tasks.instrumented(ConsumOptionServicePutBooking.class);
    }

    @Step("{0} enters consume api rest service")
    @Override
    public <T extends Actor> void performAs(T actor) {
        Map<String, String> headers = new HashMap<>();
        headers.put(Headers.CONTENT_TYPE.getKey(), Headers.CONTENT_TYPE.getValue());
        headers.put(Headers.ACCEPT.getKey(), Headers.ACCEPT.getValue());
        headers.put(Headers.AUTHORIZATION.getKey(), Headers.AUTHORIZATION.getValue());
        bookingdates = new Bookingdates((OnStage.theActorInTheSpotlight()
                .recall(SessionVariables.START_DATE.getKey())
                .toString()), (OnStage.theActorInTheSpotlight()
                .recall(SessionVariables.END_DATE.getKey())
                .toString()));
        booking = new Booking((OnStage.theActorInTheSpotlight()
                .recall(SessionVariables.FIRST_NAME.getKey())
                .toString()), (OnStage.theActorInTheSpotlight()
                .recall(SessionVariables.LAST_NAME.getKey())
                .toString()), (OnStage.theActorInTheSpotlight()
                .recall(SessionVariables.TOTAL_PRICE.getKey())), (OnStage.theActorInTheSpotlight()
                .recall(SessionVariables.DEPOSIT_PAID.getKey())), bookingdates, (OnStage.theActorInTheSpotlight()
                .recall(SessionVariables.ADDITIONAL_NEEDS.getKey())
                .toString()));
        OnStage.theActorInTheSpotlight()
                .attemptsTo(
                        Put.to((OnStage.theActorInTheSpotlight()
                                        .recall(SessionVariables.PATH.getKey())
                                        .toString()))
                                .with(
                                        request ->
                                                request
                                                        .headers(headers)
                                                        .body(booking)));
    }
}
