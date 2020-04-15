package ru.stqa.selenium.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPageHelper extends PageBase {

    public LoginPageHelper(WebDriver driver) {
        super(driver);
    }

    public final String loginPageUrl ="https://pollit.co.il/login";

    @FindBy(xpath = "//div[contains(@class,'form-box')]")
    WebElement formBoxLogIn;

    @FindBy (id ="email")
    WebElement fieldEmailLogin;

    @FindBy (id = "password")
    WebElement fieldPasswordLogin;

    @FindBy (xpath = "//a[@class='btn btn-link forgot']")
    WebElement ForgotYourPassword;

    @FindBy (xpath = "//button[@class='ui button login']")
    WebElement loginButton;

    @FindBy(xpath= "//div[@class='auth-menu']//a[@class='login'][contains(text(),'Log in')]")
    public WebElement LogInButton;

//------------------------------Methods-------------------------------------------

    public LoginPageHelper openFormBoxLogIn(){
        waitUntilElementIsClickable(LogInButton,3);
        LogInButton.click();
        waitUntilFormBox();
        return this;


    }
    public LoginPageHelper waitUntilFormBox (){
        waitUntilElementIsPresence(driver, By.xpath("//div[contains(@class,'form-box')]"),3);
        return this;
    }

}
