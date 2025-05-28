package com.cydeo.step_definitions;

import com.cydeo.pages.PracticePage;
import com.cydeo.utilities.BrowserUtils;
import com.cydeo.utilities.ConfigurationReader;
import com.cydeo.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class PracticePage_StepDefinitions {

    PracticePage practicePage = new PracticePage();

    @Given("user is on the home page")
    public void user_is_on_the_home_page() {
        Driver.getDriver().get(ConfigurationReader.getProperty("practiceUrl"));
    }

    @When("user clicks on {string} link")
    public void user_clicks_on_link(String linkText) {
        practicePage.clickLink(linkText);
    }

    @Then("user should be able to see {string} in url")
    public void user_should_be_able_to_see_in_url(String expectedInUrl) {
        BrowserUtils.verifyURLContains(expectedInUrl);
    }
}
