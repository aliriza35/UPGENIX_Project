package cydeo.pages;

import cydeo.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LogoutPage {

    public LogoutPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy (xpath = "//span[@class='oe_topbar_name']")
    public WebElement username;

    @FindBy (xpath = "//a[@data-menu='logout']")
    public WebElement logoutButton;

    @FindBy (xpath = "//a[@class='navbar-brand']")
    public WebElement header;

    @FindBy (xpath = "//h4[@class='modal-title']")
    public WebElement expiredMessage;

    @FindBy (xpath = "//span[.='SalesManager11']")
    public WebElement usernameOnTheLoginPage;

}
