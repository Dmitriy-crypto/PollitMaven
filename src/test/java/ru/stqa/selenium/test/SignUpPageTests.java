package ru.stqa.selenium.test;

import org.openqa.selenium.support.PageFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeGroups;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.selenium.pages.MainPageHelper;
import ru.stqa.selenium.pages.SignUpPageHelper;
import ru.stqa.selenium.pages.VerifyPageHelper;

import java.lang.reflect.Method;
import java.util.Arrays;

public class SignUpPageTests extends TestBase {

    private MainPageHelper mainPage;
    private SignUpPageHelper SignUpPage;
    private VerifyPageHelper VerifyPage;

    Logger log = LoggerFactory.getLogger(SignUpPageTests.class);

    //------------------------------------------Logger--------------------------------------------------
    @BeforeMethod
    public void startLogger(Method m, Object[] p) {
        log.info("TEST START :" + m.getName() + " with parameters:" + Arrays.asList(p));
    }

    @AfterMethod
    public void stopLogger(Method m) {
        log.info("STOP TEST: " + m.getName());

    }

    //----------------------------------------------------------------------------------------------------

    @BeforeGroups("Registration")
    public void initPage() {
        log.info("------Start @BeforeGroups(Registration) public void initPage");

        SignUpPage = PageFactory.initElements(driver, SignUpPageHelper.class);
        mainPage = PageFactory.initElements(driver, MainPageHelper.class);
        VerifyPage = PageFactory.initElements(driver, VerifyPageHelper.class);

        mainPage.PageMainLoadedText();
        mainPage.SignUpButton.click();
        SignUpPage.waitSignUpPageIsCorrectLoaded();

        log.info("-------Stop @BeforeGroups(Registration) public void initPage");
    }

    //---------------------------------Tests--------------------------------------------

    @Test(priority = 1, groups = "Registration")
    public void atRegisterPage() {

        Assert.assertTrue(SignUpPage.atUrlSignUpPage());
        Assert.assertTrue(SignUpPage.waitUntilElementIsLoadedCreateAnAccountButtonAndGetName());
    }

    @Test(priority = 2, dependsOnMethods = "atRegisterPage", groups = "Registration")
    public void successfulRegistrationUser() throws InterruptedException {
        SignUpPage.ElementIsClickable(SignUpPage.fieldName, 1);
        SignUpPage.enterValueToFieldsInPageOfRegistration();
        SignUpPage.createAnAccountButton.click();
        Assert.assertTrue(VerifyPage.atVerifyPage(VerifyPage.urlPageVerify));
        Assert.assertTrue(VerifyPage.waitUntilElementIsClickable(VerifyPage.ClickHere));
        Assert.assertTrue(VerifyPage.waitUntilElementIsClickable(VerifyPage.BackToLogIn));

    }

}