package com.sdvuniversity.cucumber;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import com.dhenton9000.selenium.util.DriverFactory;
import static org.junit.Assert.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/*

Feature: Test the Login for SDV University

Scenario: The user should be able to login with correct username and password
Given: User is on the login page
When: User enters correct username and password
Then: User gets access to the main page


 */
public class LoginFeatureSteps {

    private WebDriver driver;

    @Given("^User is on the login page$")
    public void user_is_on_the_login_page() {
        this.driver = DriverFactory.configureWebDriver();
        this.driver.get("http://sdettraining.com/trguitransactions/AccountManagement.aspx");

    }

    @When("^User enters correct username and password$")
    public void user_enters_correct_username_and_password() {
       
        driver.findElement(By.id("MainContent_txtUserName")).sendKeys("tim@testemail.com");
        driver.findElement(By.id("MainContent_txtPassword")).sendKeys("trpass");
        driver.findElement(By.id("MainContent_btnLogin")).click();
    }

    @Then("^User gets access to the main page$")
    public void user_gets_access_to_the_main_page() {

        String message = 
        driver.findElement(By.id("conf_message")).getText().toUpperCase().trim();
        
        assertEquals("LOGGED IN SUCCESSFULLY", message);
        
    }

}
