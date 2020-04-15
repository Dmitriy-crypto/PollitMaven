package ru.stqa.selenium.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class VerifyPageHelper extends PageBase {

    public VerifyPageHelper(WebDriver driver) {
        super(driver);
    }

    public final  String urlPageVerify = "https://pollit.co.il/verifyPage";

    @FindBy(xpath = "//h2[@class='ng-scope']")
    WebElement messageForUserCheckEmail;


    @FindBy(xpath = "//a[contains(text(),'Click here')]")
    public WebElement ClickHere;

    @FindBy(xpath = "//a[contains(text(),'Back to Log in')]")
    public WebElement BackToLogIn;



    public void waitUntilElementMessageForUserCheckEmailIsPresent() {
        waitUntilElementIsPresence(driver, By.xpath("//h2[@class='ng-scope']"), 3);

    }
    public void waitUntilElementIsClickable(WebElement element, int time) {

        try {
            new WebDriverWait(driver, time).until(ExpectedConditions.elementToBeClickable(element));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }




    public boolean atVerifyPage(String url) {
        return driver.getCurrentUrl().equals(urlPageVerify);
    }
   public  boolean waitUntilElementIsClickable(WebElement element) {

        try {
            new WebDriverWait(driver, 3).until(ExpectedConditions.
                    elementToBeClickable(element));
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

}
