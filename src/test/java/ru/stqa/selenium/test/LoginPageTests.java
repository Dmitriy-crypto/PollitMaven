package ru.stqa.selenium.test;

import org.openqa.selenium.support.PageFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import ru.stqa.selenium.pages.LoginPageHelper;
import ru.stqa.selenium.pages.MainPageHelper;
import ru.stqa.selenium.pages.SignUpPageHelper;
import ru.stqa.selenium.pages.VerifyPageHelper;

import java.lang.reflect.Method;
import java.util.Arrays;

public class LoginPageTests extends TestBase {
    private MainPageHelper mainPage;
    private SignUpPageHelper SignUpPage;
    private VerifyPageHelper VerifyPage;
    private LoginPageHelper LoginPage;

    //------------------------------------------Logger--------------------------------------------------
    Logger log = LoggerFactory.getLogger(LoginPageTests.class);

    @BeforeMethod
    public void startLogger(Method m, Object[] p) {
        log.info("---------------TEST START  " + m.getName() + " with parameters:" + Arrays.asList(p));
    }

    @AfterMethod
    public void stopLogger(Method m) {

        log.info("---------------TEST STOP  " + m.getName() + "----------------------------");

    }

    @BeforeMethod
    public void openFormBoxLogIn() {
        SignUpPage = PageFactory.initElements(driver, SignUpPageHelper.class);
        mainPage = PageFactory.initElements(driver, MainPageHelper.class);
        VerifyPage = PageFactory.initElements(driver, VerifyPageHelper.class);
        LoginPage = PageFactory.initElements(driver, LoginPageHelper.class);

        mainPage.waitMainPageIsCorrectLoaded();
        mainPage.PageMainLoadedText();
        LoginPage.openFormBoxLogIn();

    }






}

























