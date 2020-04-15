package ru.stqa.selenium.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public abstract class PageBase {

    WebDriver driver;
    Logger log = LoggerFactory.getLogger(PageBase.class);

    public PageBase(WebDriver driver) {
        this.driver = driver;
    }

    //---------------------methods Wait--------------------------------------------------------
    public void waitUntilElementIsClickable(WebElement element, int time) {

        try {
            new WebDriverWait(driver, time).
                    until(ExpectedConditions.elementToBeClickable(element));
            log.info("DONE: public void waitUntilElementIsClickable " + element);

        } catch (Exception e) {
            log.error("-------------------------------------------------------");
            log.error("The item is not clickable " + element + " Waiting " + time);
            log.error("-------------------------------------------------------");

            e.printStackTrace();

        }
    }

    public void waitUntilElementIsVisible(WebElement element, int time) {

        try {
            new WebDriverWait(driver, time).
                    until(ExpectedConditions.visibilityOf(element));
            log.info("DONE: public void waitUntilElementIsVisible " + element);
        } catch (Exception e) {
            log.error("-------------------------------------------------------");
            log.error("The item is not Visible " + element + " Waiting " + time);
            log.error("-------------------------------------------------------");
            e.printStackTrace();

        }
    }

    public void waitUntilElementIsPresence(WebDriver driver, By locator, int time) {

        try {
            new WebDriverWait(driver, time).until(ExpectedConditions.presenceOfElementLocated(locator));
            log.info("DONE: public void waitUntilElementIsPresence " + locator);

        } catch (Exception e) {
            log.error("-------------------------------------------------------");
            log.error("The item is not Located " + locator + " Waiting " + time);
            log.error("-------------------------------------------------------");
            e.printStackTrace();

        }

    }

    //-----------------------------------Wait boolean---------------------------------------
    public boolean waitUntilElementIsLoadedText(WebDriver driver, By locator, String s, int time) {
        try {
            new WebDriverWait(driver, time).until(ExpectedConditions.textToBe(locator, s));
            log.info("DONE: public boolean waitUntilElementIsLoadedText " + s + " " + locator);
            return true;
        } catch (Exception e) {
            log.error("-------------------------------------------------------");
            log.error("The item is not Loaded Text " + locator + "Text  " + s + " Waiting " + time);
            log.error("-------------------------------------------------------");
            e.printStackTrace();
        }
        return false;
    }

    public boolean waitUntilElementIsNotLoaded(WebDriver driver, By locator, int time) {
        try {
            new WebDriverWait(driver, time).until(ExpectedConditions.invisibilityOfElementLocated(locator));
            log.info("DONE: public boolean waitUntilElementIsNotLoaded " + locator);
            return true;
        } catch (Exception e) {
            log.error("-------------------------------------------------------");
            log.error("The item is Loaded " + locator + " Waiting " + time);
            log.error("-------------------------------------------------------");
            e.printStackTrace();
        }
        return false;
    }
    public  boolean ElementIsClickable(WebElement element, int time) {

        try {
            new WebDriverWait(driver, time).
                    until(ExpectedConditions.elementToBeClickable(element));
            log.info("DONE: public void waitUntilElementIsClickable " + element);
            return true;
        } catch (Exception e) {
            log.error("-------------------------------------------------------");
            log.error("The item is not clickable " + element + " Waiting " + time);
            log.error("-------------------------------------------------------");

            e.printStackTrace();
            return false;
        }
    }
    public boolean atUrlThisPage(String url, String namepage) {

        try{
            driver.getCurrentUrl().equals(url);
            log.info("DONE: public boolean atUrlThisPage " + url);
            log.info("This URL"+ url +" belong to this page "+namepage);
            return true;
        }catch (Exception e){
            log.error("-------------------------------------------------------");
            log.error("This URL"+ url +" does not belong to this page "+namepage);
            log.error("-------------------------------------------------------");
            e.printStackTrace();
            return false;

        }

    }

}