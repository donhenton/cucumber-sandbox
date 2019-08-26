package com.dhenton9000.cucumber.sample;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import static org.junit.Assert.*;

class IsItFriday {

    static String isItFriday(String today) {
        return "Friday".equals(today) ? "TGIF" : "Nope";
    }
}

public class WeekDaySteps {

    private String today;
    private String actualAnswer;

    @Given("^today is \"([^\"]*)\"$")
    public void today_is(String today) {
        this.today = today;
    }

   

    @When("^I ask whether it's Friday yet$")
    public void i_ask_whether_it_s_Friday_yet() {
        // Write code here that turns the phrase above into concrete actions
        actualAnswer = IsItFriday.isItFriday(today);
    }

    // @Then("^I should be told \"([^\"]*)\"$") this is the same as the other @Then below
    ///public void i_should_be_told(String expectedAnswer) {
    @Then("I should be told {string}")
    public void i_should_be_told(String expectedAnswer) {
        // Write code here that turns the phrase above into concrete actions
        assertEquals(expectedAnswer, actualAnswer);
    }
}
