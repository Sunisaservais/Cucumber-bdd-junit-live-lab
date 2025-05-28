package com.cydeo.step_definitions;

//In this class will be able to create "pre" and "post" condition for ALL the SCENARIOS and even STEPS.

import com.cydeo.utilities.BrowserUtils;
import com.cydeo.utilities.ConfigurationReader;
import com.cydeo.utilities.Driver;
import io.cucumber.java.After;
import io.cucumber.java.BeforeStep;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public class Hooks {
    /*
    //import the @Before coming from io.cucumber.java
    //@Before (order = 1)
    //@Before: Running before each scenario
    public void setupMethod() {
    }

    //@Before (value = "@login",order = 2)
    //@Before: Running before each scenario
    public void login_scenario_before() {

    }

    //after will be executed automatically after every scenario in the project
    //@After: RUNNING AFTER EACH SCENARIO
 */
    /*

    //@BeforeStep
    //@BeforeStep: Running before each step
    public void setupStep() {

    }

    //@AfterStep
    //@AfterStep: Running after each step
    public void teardownStep() {

    }
     */

    @After
    public void teardownMethod(Scenario scenario) {


        if (scenario.isFailed()) {
            byte[] screenshot = ((TakesScreenshot) Driver.getDriver()).getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshot, "image/png", scenario.getName());
        }

        Driver.closeDriver();
    }

    @BeforeStep
    public void beforeStep(Scenario scenario) {
        BrowserUtils.waitForPageToLoad(3);
        BrowserUtils.sleep(Integer.parseInt(ConfigurationReader.getProperty("slow.motion")));
    }
}
