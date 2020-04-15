package ru.stqa.selenium.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MainPageHelper extends PageBase {

    private static final String mainURL = "https://pollit.co.il/";

    //-------------------------------------------------------------------------------------

    @FindBy(xpath = "//a[@class='signUp']")
    public WebElement SignUpButton;

    @FindBy(xpath = "//div[@class='sign-up-box']")
    WebElement signUpBox;

    @FindBy(xpath = "//div[@class='logo-box']//a")
    public WebElement LogoMainPage;

    @FindBy(xpath = "//p[contains(text(),'George Carlin')]")
    WebElement textArea;

    @FindBy(xpath = "//div[@class='auth-menu']//a[@class='login'][contains(text(),'Log in')]")
    public WebElement boxLogin;

    @FindBy(xpath = "//div[contains(@class,'form-box')]")
    WebElement formBoxLogIn;

    @FindBy(xpath = "//div[@class='auth-menu']//a[@class='login'][contains(text(),'Log in')]")
    public WebElement LogInButton;
    //--------------------------------------------------------------------------

    public MainPageHelper(WebDriver driver) {
        super(driver);
    }

    //-----------------------------------------------------------------------------------

    public MainPageHelper waitMainPageIsCorrectLoaded() {
        waitTextOfMainPageLoaded();
        waitElementOfMainPageIsClickable();
        return this;
    }

    public MainPageHelper waitTextOfMainPageLoaded() {
        waitUntilElementIsVisible(textArea, 3);
        return this;
    }

    public MainPageHelper waitElementOfMainPageIsClickable() {
        waitUntilElementIsClickable(signUpBox, 3);
        return this;
    }

/*public LoginPageHelper waitUntilPageIsLoaded(){

        waitUntilElementIsClickable(signInButton,20);
        return this;
    }

    public LoginPageHelper openLoginPage(){
        waitUntilElementIsClickable(loginIcon,20);
        loginIcon.click();
        waitUntilPageIsLoaded();
        return this;
    }

    public Boolean correctPageIsLoaded(){
        return registrationLink.getText().contains("registration");
    }*/

    public boolean formBoxLogInElementIsNotLoaded() {
        return waitUntilElementIsNotLoaded(driver, By.xpath("//div[contains(@class,'form-box')]"), 3);
    }

    public boolean PageMainLoadedText() {
        log.info("Start public boolean PageMainLoadedText");
        return waitUntilElementIsLoadedText(driver, By.xpath("//p[contains(text(),'George Carlin')]"),
                "George Carlin", 3);

    }

    public boolean atUrlMainPage() {
        log.info("START: public boolean atUrlMainPage");
        return atUrlThisPage(mainURL, "Main Page");

    }

    public boolean buttonFreeSignUpClickable() {
        log.info("START: public boolean buttonFreeSignUpClickable");
        return ElementIsClickable(signUpBox, 3);

    }

}
