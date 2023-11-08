package com.yape.apitest.tasks;

import com.yape.apitest.conf.SessionVariables;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.rest.interactions.Get;
import net.thucydides.core.annotations.Step;

public class ConsumOptionServiceGetBooking implements Task {

    public static ConsumOptionServiceGetBooking apiRest() {
        return Tasks.instrumented(ConsumOptionServiceGetBooking.class);
    }

    @Step("{0} enters consume api rest service")
    @Override
    public <T extends Actor> void performAs(T actor) {
        OnStage.theActorInTheSpotlight()
                .attemptsTo(
                        Get.resource((OnStage.theActorInTheSpotlight()
                                .recall(SessionVariables.PATH.getKey())
                                .toString()) + (OnStage.theActorInTheSpotlight()
                                .recall(SessionVariables.FILTER_PERSONAL_INFORMATION.getKey())
                                .toString()) + (OnStage.theActorInTheSpotlight()
                                .recall(SessionVariables.FILTER_DATE_INFORMATION.getKey())
                                .toString())));
    }
}
