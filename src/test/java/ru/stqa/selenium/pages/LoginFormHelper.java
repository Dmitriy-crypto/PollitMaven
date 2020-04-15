package ru.stqa.selenium.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginFormHelper extends PageBase {

        @FindBy(xpath="//div[contains(@class,'form-box')]")
    public WebElement boxLogin;




    public LoginFormHelper(WebDriver driver) {
        super(driver);
    }
}
