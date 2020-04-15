package ru.stqa.selenium.test;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
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

    @BeforeClass
    public void initPage() {
        SignUpPage = PageFactory.initElements(driver, SignUpPageHelper.class);
        mainPage = PageFactory.initElements(driver, MainPageHelper.class);
        VerifyPage = PageFactory.initElements(driver, VerifyPageHelper.class);
        LoginPage = PageFactory.initElements(driver, LoginPageHelper.class);
    }

    @BeforeMethod
    public void startLogger(Method m, Object[]p)  {
        log.info("Start Tests: "+m.getName()+" with parameters: "+ Arrays.asList(p));
    }

    @AfterMethod
    public void stopLogger(Method m)  {
        log.info("Stop Tests: "+m.getName());
    }
}
