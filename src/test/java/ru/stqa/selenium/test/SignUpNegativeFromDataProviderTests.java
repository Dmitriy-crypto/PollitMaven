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
import ru.stqa.selenium.utils.DataProviders;

import java.lang.reflect.Method;
import java.util.Arrays;

public class SignUpNegativeFromDataProviderTests extends TestBase {

    private MainPageHelper mainPage;
    private SignUpPageHelper SignUpPage;
    private VerifyPageHelper VerifyPage;

    //------------------------------------------Logger--------------------------------------------------
    Logger log = LoggerFactory.getLogger(SignUpNegativeFromDataProviderTests.class);

    @BeforeMethod
    public void startLogger(Method m, Object[] p) {
        log.info("---------------TEST START  " + m.getName() + " with parameters:" + Arrays.asList(p));
    }

    @AfterMethod
    public void stopLogger(Method m) {

        log.info("---------------TEST STOP  " + m.getName() + "----------------------------");

    }

    //-----------------------------------Before and After Methods -----------------------------------------------------------------

    @BeforeGroups(groups = "registrationNegative")
    public void initPageForNegativeRegistrationFromDataProvider() {
        log.info("----START @BeforeGroups(groups = \"registrationNegative\")- public void initPageForNegativeRegistrationFromDataProvider");

        SignUpPage = PageFactory.initElements(driver, SignUpPageHelper.class);
        mainPage = PageFactory.initElements(driver, MainPageHelper.class);
        VerifyPage = PageFactory.initElements(driver, VerifyPageHelper.class);

        mainPage.PageMainLoadedText();

        mainPage.SignUpButton.click();

        log.info("mainPage.SignUpButton.click()");

        SignUpPage.waitSignUpPageIsCorrectLoaded();
        SignUpPage.atUrlSignUpPage();

        log.info("-----STOP @BeforeGroups(groups = \"registrationNegative\") public void initPageForNegativeRegistrationFromDataProvider");

    }

    @AfterMethod()
    public void navigateToSignUpPage() throws InterruptedException {

        String urlCurrent = driver.getCurrentUrl();

        if (urlCurrent.equals(VerifyPage.urlPageVerify)) {
            log.warn("--------------------------------------------------------------");
            log.warn("-----FALSE---Test negativeRegistrationUserFromDataProvider");
            log.warn("--------------------------------------------------------------");

            log.info("-------START @AfterMethod navigateToSignUpPage-------------------------------");
            log.info("This Page " + urlCurrent + " click Back To LogIn");
            VerifyPage.BackToLogIn.click();
            Thread.sleep(1000);
            mainPage.SignUpButton.click();
            log.info("Click Sign Up");
            log.info("Go to " + SignUpPage.urlPageRegistration);
            SignUpPage.waitSignUpPageIsCorrectLoaded();
            SignUpPage.atUrlSignUpPage();

        } else {
            log.info("-------START @AfterMethod navigateToSignUpPage-------------------------------");
            log.info("-------keep trying to test");

        }
        log.info("---------STOP @AfterMethod navigateToSignUpPage---------------------------------");
    }
    //-------------------------------------------------Test-------------------------------------------------------------------

    @Test(dataProviderClass = DataProviders.class, dataProvider = "registrationNegative", groups = "registrationNegative")

    public void negativeRegistrationUserFromDataProvider(String name,
                                                         String surname,
                                                         String email,
                                                         String phone,
                                                         String password,
                                                         String passwordConfirm)
            throws InterruptedException {

        SignUpPage.ElementIsClickable(SignUpPage.fieldName, 1);
        SignUpPage.enterValueToFieldsInPageOfRegistrationFromDataProvider(
                name,
                surname,
                email,
                phone,
                password,
                passwordConfirm);
        Thread.sleep(1000);
        SignUpPage.createAnAccountButton.click();
        log.info("Click createAnAccountButton");
        Thread.sleep(3000);
        log.info("----Start Assert.assertTrue(SignUpPage.atUrlSignUpPage());");
        Assert.assertTrue(SignUpPage.atUrlSignUpPage());

        log.info("-----TRUE---Test negativeRegistrationUserFromDataProvider");

    }

}