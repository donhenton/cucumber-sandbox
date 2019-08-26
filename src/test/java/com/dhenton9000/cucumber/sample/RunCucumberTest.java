package com.dhenton9000.cucumber.sample;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;



@RunWith(Cucumber.class)
@CucumberOptions(plugin = {"pretty","html:target/report/simple"})
public class RunCucumberTest {
}


//https://cucumber.io/docs/guides/10-minute-tutorial/

//https://www.tutorialspoint.com/cucumber/cucumber_tags.htm

//https://docs.behat.org/en/v2.5/guides/1.gherkin.html

//https://www.baeldung.com/cucumber-spring-integration

//https://www.baeldung.com/cucumber-rest-api-testing

//https://github.com/eugenp/tutorials/tree/master/spring-cucumber/src/test/java/com/baeldung