 

package com.sdvuniversity.cucumber;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;


@RunWith(Cucumber.class)
@CucumberOptions(plugin = {"pretty","html:target/report/sdv"},
          features="src/test/resources/com/sdvuniversity/cucumber",
         glue="com.sdvuniversity.cucumber")
public class RunSdvUniversityTest {

}


