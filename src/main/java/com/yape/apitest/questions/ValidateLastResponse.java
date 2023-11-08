package com.yape.apitest.questions;

import com.yape.apitest.models.Booking;
import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

public class ValidateLastResponse implements Question<Booking> {

    public static ValidateLastResponse forResource() {
        return new ValidateLastResponse();
    }
    @Override
    public Booking answeredBy(Actor actor) {
        Booking booking = SerenityRest.lastResponse()
                .jsonPath()
                .getObject("", Booking.class);
        return booking;
    }
}
