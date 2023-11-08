package com.yape.apitest.tasks;

import com.yape.apitest.conf.SessionVariables;
import com.yape.apitest.models.UserData;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.rest.interactions.Post;
import net.thucydides.core.annotations.Step;

public class ConsumOptionServiceAuthPost implements Task {
    UserData userData;
    public static ConsumOptionServiceAuthPost apiRest() {
        return Tasks.instrumented(ConsumOptionServiceAuthPost.class);
    }

    @Step("{0} enters consume api rest service")
    @Override
    public <T extends Actor> void performAs(T actor) {
        userData = new UserData((OnStage.theActorInTheSpotlight()
                .recall(SessionVariables.USER_NAME.getKey())
                .toString()), (OnStage.theActorInTheSpotlight()
                .recall(SessionVariables.PASSWORD.getKey())
                .toString()));
        OnStage.theActorInTheSpotlight()
                .attemptsTo(
                        Post.to((OnStage.theActorInTheSpotlight()
                                        .recall(SessionVariables.PATH.getKey())
                                        .toString()))
                                .with(
                                        request ->
                                                request
                                                        .header("Content-Type", "application/json")
                                                        .body(userData)));
    }
}
