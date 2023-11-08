package com.yape.apitest.runners.ping;

import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        features = "src/test/resources/features/booking/ping_api.feature",
        glue = {"com.yape.apitest.conf", "com.yape.apitest.stepdefinitions"},
        snippets = CucumberOptions.SnippetType.CAMELCASE)
public class PingApiRunner {
}
