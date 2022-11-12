package cydeo.step_definitions;

import cydeo.pages.LoginPage;
import cydeo.pages.LogoutPage;
import cydeo.utilities.BrowserUtils;
import cydeo.utilities.ConfigurationReader;
import cydeo.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.Cookie;

import java.util.ArrayList;
import java.util.List;

import static cydeo.utilities.Driver.getDriver;

public class LogoutPage_StepDefinitions {

    LoginPage loginPage = new LoginPage();
    LogoutPage logoutPage = new LogoutPage();



    @Given("user has logged in")
    public void user_has_logged_in() {
        getDriver().get(ConfigurationReader.getProperty("upgenix.login.url"));
        loginPage.emailBox.sendKeys(ConfigurationReader.getProperty("upgenix.email"));
        loginPage.passwordBox.sendKeys(ConfigurationReader.getProperty("upgenix.password"));
        loginPage.loginButton.click();
    }

    @When("user clicks the username at the top right of the page")
    public void user_clicks_the_username_at_the_top_right_of_the_page() {
        logoutPage.username.click();
    }

    @When("user clicks the logout button")
    public void user_clicks_the_logout_button() {
        logoutPage.logoutButton.click();
    }

    @Then("user should see at the top left of the page the header is {string}")
    public void user_should_see_the_header_is(String expectedHeader) {
        String actualHeader = logoutPage.header.getText();
        Assert.assertEquals(expectedHeader,actualHeader);
    }

    @When("user navigates the back")
    public void user_navigates_the_back() {
        getDriver().navigate().back();
    }

    @Then("user should see {string} message")
    public void user_should_see_message(String expectedMessage) {
        String actualMessage = logoutPage.expiredMessage.getText();
        Assert.assertEquals(expectedMessage, actualMessage);
    }

    @When("user goes to Upgenix login page")
    public void user_goes_to_upgenix_login_page() {

        getDriver().get(ConfigurationReader.getProperty("upgenix.login.url"));

    }

    @Then("user should not see his or her username at the right of the page")
    public void user_should_not_see_his_or_her_username_at_the_right_of_the_page() {
        Assert.assertFalse(logoutPage.usernameOnTheLoginPage.isDisplayed());
    }


    @When("user opens new tab and closes the previous tab")
    public void userOpensNewTabAndClosesThePreviousTab() {
        String oldTab = getDriver().getWindowHandle();
        String newTab = BrowserUtils.openNewTabAndSwitch();
        getDriver().switchTo().window(oldTab).close();
        getDriver().switchTo().window(newTab);
    }
}
