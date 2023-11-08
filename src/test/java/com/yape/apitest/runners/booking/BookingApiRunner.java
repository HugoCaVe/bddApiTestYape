package com.yape.apitest.runners.booking;

import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        features = "src/test/resources/features/booking/booking_api.feature",
        glue = {"com.yape.apitest.conf", "com.yape.apitest.stepdefinitions"},
        snippets = CucumberOptions.SnippetType.CAMELCASE)
public class BookingApiRunner {
}
