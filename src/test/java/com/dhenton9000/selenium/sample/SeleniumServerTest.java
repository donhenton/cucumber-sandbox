package com.dhenton9000.selenium.sample;

import com.dhenton9000.selenium.util.DriverFactory;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

import static org.hamcrest.core.Is.is;
import org.junit.After;
import static org.junit.Assert.assertThat;
import org.junit.Before;
import org.junit.Ignore;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Tests for selenium standalone server.
 * https://examples.javacodegeeks.com/enterprise-java/selenium/selenium-standalone-server-example/
 *
 * @author dhenton
 * @since 06.28.2019
 */
@Ignore
public class SeleniumServerTest {

    private static final Logger LOG = LoggerFactory.getLogger(SeleniumServerTest.class);
    private WebDriver driver;
    
    @Before 
    public void before() {
        driver = DriverFactory.configureWebDriver();
    }
    @Test
    public void simpleWebTest()  {
        
        this.driver.get("http://www.javacodegeeks.com/");
        WebElement element = driver.findElement(By.name("s"));
        element.sendKeys("selenuim");
        element.submit();
        assertThat(
                driver.getTitle(),
                is("You searched for selenuim | Java Code Geeks")
        );
       
        LOG.debug("Starting driver");
    }
    
    @After
    public void after() {
        DriverFactory.quitDriver(driver);
    }

}
