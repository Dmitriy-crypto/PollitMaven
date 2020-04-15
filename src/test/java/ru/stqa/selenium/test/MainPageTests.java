package ru.stqa.selenium.test;

import org.openqa.selenium.support.PageFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.selenium.pages.MainPageHelper;

import java.lang.reflect.Method;
import java.util.Arrays;

public class MainPageTests extends TestBase {

    private MainPageHelper mainPage;
    //---------Logger-----------------------------------------------------------------------
    Logger log = LoggerFactory.getLogger(MainPageTests.class);

    @BeforeMethod
    public void startLogger(Method m, Object[] p) {
        log.info("Start Tests: " + m.getName() + " with parameters: " + Arrays.asList(p));

    }

    @AfterMethod
    public void stopLogger(Method m) {
        log.info("Stop Tests: " + m.getName());
    }

    //------------------------Star Test ----------------------------------------------------------
    @BeforeMethod
    public void initTests() {
        mainPage = PageFactory.initElements(driver, MainPageHelper.class);
        mainPage.waitMainPageIsCorrectLoaded();
    }

    @Test
    public void atMainPageIsCorrect() {
        Assert.assertTrue(mainPage.atUrlMainPage());
        Assert.assertTrue(mainPage.buttonFreeSignUpClickable());
        Assert.assertTrue(mainPage.PageMainLoadedText());
        Assert.assertTrue(mainPage.formBoxLogInElementIsNotLoaded());
    }
}
