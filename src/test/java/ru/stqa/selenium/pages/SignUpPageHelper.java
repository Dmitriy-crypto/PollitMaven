package ru.stqa.selenium.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.stqa.selenium.test.SignUpPageTests;

public class SignUpPageHelper extends PageBase {

    Logger log = LoggerFactory.getLogger(SignUpPageTests.class);

    public SignUpPageHelper(WebDriver driver) {
        super(driver);
    }

    public final String urlPageRegistration = "https://pollit.co.il/register";

    /*@FindBy(xpath = "//a[@class='signUp']")
    WebElement SignUpButton1;*/

    @FindBy(xpath = "//a[@class='signUp']")
    public
    WebElement SignUp;

    //fields of form registration
    @FindBy(id = "name")
    public WebElement fieldName;

    @FindBy(id = "surname")
    WebElement fieldSurName;

    @FindBy(id = "email")
    WebElement fieldEmail;

    @FindBy(id = "phone")
    WebElement fieldPhone;

    @FindBy(id = "password")
    WebElement fieldPassword;

    @FindBy(id = "password-confirm")
    WebElement fieldPasswordConfirmation;
    //---------------------------------------------------------
    //createAnAccountButton on form registration
    @FindBy(xpath = "//button[@class='ui button login']")
    public WebElement createAnAccountButton;

    public static final String NAME = "Tester";
    public static final String SURNAME = "Testerovich";
    public static final String EMAIL = "test.tester@gmail.com";
    public static final String PHONE = "+972546665544";
    public static final String PASSWORD = "Tester123";
//-----------------------------------------------------------------------------------------------------

    public boolean atUrlSignUpPage() {

        log.info("--Start: public boolean atUrlSignUpPage");
        String urlCurrent = driver.getCurrentUrl();


            return urlCurrent.equals(urlPageRegistration);

        }



    public void waitUntilElementCreateAnAccountButtonIsPresent() {
        waitUntilElementIsPresence(driver, By.xpath("//button[@class='ui button login']"), 3);

    }

    public boolean waitUntilElementIsLoadedCreateAnAccountButtonAndGetName() {

        return waitUntilElementIsLoadedText(driver, By.xpath("//button[@class='ui button login']"),
                "CREATE AN ACCOUNT", 3);
    }

    public void enterValueToFieldsInPageOfRegistration() throws InterruptedException {
        log.info("Start Method: public void enterValueToFieldsInPageOfRegistration");
        fieldName.click();
        fieldName.sendKeys(NAME);
        fieldSurName.clear();
        fieldSurName.sendKeys(SURNAME);
        fieldEmail.clear();
        fieldEmail.sendKeys(EMAIL);
        fieldPhone.clear();
        fieldPhone.sendKeys(PHONE);
        fieldPassword.clear();
        fieldPassword.sendKeys(PASSWORD);
        fieldPasswordConfirmation.clear();
        fieldPasswordConfirmation.sendKeys(PASSWORD);
        Thread.sleep(1000);
        log.info("Stop Method: public void enterValueToFieldsInPageOfRegistration");

    }

    public String toString() {
        return "SignUpPageHelper{" +
                "fieldName=" + fieldName +
                ", fieldSurName=" + fieldSurName +
                ", fieldEmail=" + fieldEmail +
                ", fieldPhone=" + fieldPhone +
                ", fieldPassword=" + fieldPassword +
                ", fieldPasswordConfirmation=" + fieldPasswordConfirmation +
                '}';
    }

    public void enterValueToFieldsInPageOfRegistrationFromDataProvider
            (String name,
             String surname,
             String email,
             String phone,
             String password,
             String passwordConfirm) throws InterruptedException {

        log.info("Start: public void enterValueToFieldsInPageOfRegistrationFromDataProvider");

        fieldName.click();

        fieldName.clear();
        fieldName.sendKeys(name);

        fieldSurName.clear();
        fieldSurName.sendKeys(surname);

        fieldEmail.clear();
        fieldEmail.sendKeys(email);

        fieldPhone.clear();
        fieldPhone.sendKeys(phone);

        fieldPassword.clear();
        fieldPassword.sendKeys(password);

        fieldPasswordConfirmation.clear();
        fieldPasswordConfirmation.sendKeys(passwordConfirm);

        Thread.sleep(1000);

        log.info("Stop: public void enterValueToFieldsInPageOfRegistrationFromDataProvider");
    }

    public SignUpPageHelper waitSignUpPageIsCorrectLoaded() {
        log.info("Start: public SignUpPageHelper waitSignUpPageIsCorrectLoaded");
        waitUntilElementIsVisible(fieldName, 3);
        ElementIsClickable(createAnAccountButton, 3);
        log.info("Stop: public SignUpPageHelper waitSignUpPageIsCorrectLoaded");

        return this;
    }

}

