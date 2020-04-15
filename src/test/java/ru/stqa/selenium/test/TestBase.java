package ru.stqa.selenium.test;

import org.openqa.selenium.By;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.events.AbstractWebDriverEventListener;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.*;
import ru.stqa.selenium.factory.WebDriverPool;
import ru.stqa.selenium.utils.SuiteConfiguration;

import java.io.IOException;
import java.lang.reflect.Method;
import java.net.URL;
import java.util.Arrays;

/**
 * Base class for TestNG-based test classes
 */
public class TestBase {

    public static final String mainURL = "https://pollit.co.il/";

    protected static URL gridHubUrl = null;
    protected static String baseUrl;
    protected static Capabilities capabilities;

    Logger log = LoggerFactory.getLogger(TestBase.class);
    public static TestBase testBase = new TestBase();
    EventFiringWebDriver driver;

    @BeforeSuite
    public void initTestSuite() throws IOException {

        SuiteConfiguration config = new SuiteConfiguration();
        baseUrl = config.getProperty("site.url");
        if (config.hasProperty("grid.url") && !"".equals(config.getProperty("grid.url"))) {
            gridHubUrl = new URL(config.getProperty("grid.url"));
        }
        capabilities = config.getCapabilities();
        log.info("Method completed: @BeforeSuite public void initTestSuite()");
    }

    @BeforeTest
    public void initWebDriver() {
        log.info("@BeforeTest  public void initWebDriver >> START:");
        driver = new EventFiringWebDriver(WebDriverPool.DEFAULT.
                getDriver(gridHubUrl, capabilities));
        driver.register(new MyListener());
        driver.get(baseUrl);
        log.info("Opened the site  - " + baseUrl);
        driver.manage().window().maximize();

        log.info("@BeforeTest  public void initWebDriver >> COMPLETED");
    }

    @AfterSuite(alwaysRun = true)
    public void tearDown() {
        WebDriverPool.DEFAULT.dismissAll();
        log.info("---------------------------------------------------------------------");
        log.info("" + baseUrl + " CLOSED");
        log.info("@AfterSuite public void tearDown() >> COMPLETED");

    }

    //---------------------------Logger and Listener----------------------------
    @BeforeMethod
    public void startLogger(Method m, Object[] p) {
        log.info("Start Tests: " + m.getName() + " with parameters: " + Arrays.asList(p));
    }

    @AfterMethod
    public void stopLogger(Method m) {
        log.info("Stop Tests: " + m.getName());
    }

    //-----------------------------------------------------

    public static class MyListener extends AbstractWebDriverEventListener {

        Logger log = LoggerFactory.getLogger(MyListener.class);

        @Override
        public void beforeFindBy(By by, WebElement element, WebDriver driver) {
            log.info("Trying to find a variable: " + by);

        }

        @Override
        public void afterFindBy(By by, WebElement element, WebDriver driver) {
            log.info("******** Found a variable: " + by);
        }

        @Override
        public void onException(Throwable throwable, WebDriver driver) {

            log.error(" No found: " + throwable);
           /* File tmp = ((TakesScreenshot) driver).
                    getScreenshotAs(OutputType.FILE);
            File screen = new File("src/test/resources/Screenshot/screen_" + System.currentTimeMillis() + ".png");
            try {
               //Files.copy(tmp, screen);
                log.error("ERROR!!!  See to Screenshot" + screen);
            } catch (IOException e) {
                e.printStackTrace();
                log.error("ERROR!!!  Read to >>>", throwable);



            }*/

        }
    }
}



