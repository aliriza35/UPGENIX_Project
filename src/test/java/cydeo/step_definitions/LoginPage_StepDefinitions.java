package cydeo.step_definitions;

import cydeo.pages.LoginPage;
import cydeo.utilities.ConfigurationReader;
import cydeo.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage_StepDefinitions {

    LoginPage loginPage= new LoginPage();

    @Given("user is on the login page")
    public void user_is_on_the_login_page() {
        Driver.getDriver().get(ConfigurationReader.getProperty("upgenix.login.url"));
    }

    @When("user enters username {string}")
    public void user_enters_username(String string) {
        loginPage.emailBox.sendKeys(ConfigurationReader.getProperty("upgenix.email"));
    }

    @When("user enters password {string}")
    public void user_enters_password(String string) {
        loginPage.passwordBox.sendKeys(ConfigurationReader.getProperty("upgenix.password"));
    }

    @When("user clicks login button")
    public void user_clicks_login_button() {
        loginPage.loginButton.click();
    }

    @Then("user should login homepage successfully")
    public void user_should_login_homepage_successfully() {
        String expectedTitle="#Inbox - Odoo";
        WebDriverWait wait= new WebDriverWait(Driver.getDriver(),10);
        wait.until(ExpectedConditions.titleContains("Inbox"));
        String actualTitle= Driver.getDriver().getTitle();
        Assert.assertEquals(expectedTitle,actualTitle);
    }

    @When("user enters invalid password {string}")
    public void user_enters_invalid_password(String invalidPassword) {
        loginPage.passwordBox.sendKeys(invalidPassword);
    }

    @Then("wrong login or password should be displayed")
    public void wrong_login_or_password_should_be_displayed() {
        String expectedMessage= "Wrong login/password";
        String actualMessage= loginPage.invalidLoginMessage.getText();
        Assert.assertEquals(expectedMessage,actualMessage);
    }

    @When("user enters invalid username {string}")
    public void user_enters_invalid_username(String invalidUsername) {
        loginPage.emailBox.sendKeys(invalidUsername);
    }

    @Then("Please fill out this field message should display")
    public void please_fill_out_this_field_message_should_display() {
        String message = loginPage.emailBox.getAttribute("validationMessage");
        Assert.assertEquals("Please fill out this field.",message);
    }

    @Then("user should see the password in bullet signs")
    public void user_should_see_the_password_in_bullet_signs() {

    }

    @When("user presses the Enter key")
    public void user_presses_the_enter_key() {
        loginPage.loginButton.sendKeys(Keys.ENTER);
    }

}
