package ru.stqa.selenium.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPageHelper extends PageBase {

    public LoginPageHelper(WebDriver driver) {
        super(driver);
    }

    public final String loginPageUrl ="https://pollit.co.il/login";

    @FindBy (id ="email")
    WebElement fieldEmailLogin;

    @FindBy (id = "password")
    WebElement fieldPasswordLogin;

    @FindBy (xpath = "//a[@class='btn btn-link forgot']")
    WebElement ForgotYourPassword;

    @FindBy (xpath = "//button[@class='ui button login']")
    WebElement loginButton;
}
