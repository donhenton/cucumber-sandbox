package com.dhenton9000.selenium.util;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.logging.LoggingPreferences;
import java.util.logging.Level;
import org.openqa.selenium.chrome.ChromeOptions;
 
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DriverFactory {

    private static final String REMOTE_URL = "http://localhost:4444/wd/hub";
    private static final Logger LOG = LoggerFactory.getLogger(DriverFactory.class);
    public enum DRIVER_TYPES {

        FireFox, InternetExplorer, Opera, Safari, Chrome;
    }

    public static WebDriver configureWebDriver() {
        WebDriver driver = null;
        LoggingPreferences logs = new LoggingPreferences();
        logs.enable(LogType.BROWSER, Level.SEVERE);
        logs.enable(LogType.CLIENT, Level.SEVERE);
        logs.enable(LogType.DRIVER, Level.SEVERE);
        logs.enable(LogType.PERFORMANCE, Level.SEVERE);
        logs.enable(LogType.PROFILER, Level.SEVERE);
        logs.enable(LogType.SERVER, Level.SEVERE);
        ChromeOptions desiredCapabilities = new ChromeOptions();
        desiredCapabilities.setCapability(CapabilityType.LOGGING_PREFS, logs);

        try {

            driver = new RemoteWebDriver(new URL(REMOTE_URL), desiredCapabilities);
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        } catch (MalformedURLException ex) {
            throw new RuntimeException("Malformed remote url '" + REMOTE_URL + "'");
        }
         
        return driver;
    }
    
    /** 
     * this closes ALL Sessions
     * @param driver
     **/
    public static void quitDriver(WebDriver driver) {
        
        try {
             driver.quit();
        } catch(Exception err) {
            LOG.error("problems quitting the selenium driver");
          
        }
    }
    
    /**
     * close the current session on the browser
     * 
     * @param driver 
     */
    public static void closeCurrent(WebDriver driver) {
        
          try {
             driver.close();
        } catch(Exception err) {
            LOG.error("problems closing the selenium driver");
          
        }
        
    }
    
}
