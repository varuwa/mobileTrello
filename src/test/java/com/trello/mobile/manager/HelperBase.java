package com.trello.mobile.manager;

import com.google.common.io.Files;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;

public class HelperBase {

    AppiumDriver driver;

    public HelperBase(AppiumDriver driver) {
        this.driver = driver;
    }

    public void click(By locator) {
        driver.findElement(locator).click();
    }

    public void waitForElementLocatedAndClick(By locator, int timeOut) {
        new WebDriverWait (driver, timeOut).until(ExpectedConditions.presenceOfElementLocated(locator)).click();
    }

    public void waitForElementClickableAndClick(By locator, int timeOut) {
        new WebDriverWait (driver, timeOut).until(ExpectedConditions.elementToBeClickable(locator)).click();
    }

    public void type(By locator, String text) {
        if(text != null){
            waitForElementLocatedAndClick(locator, 30);
            driver.findElement(locator).clear();
            driver.findElement(locator).sendKeys(text);
        }
    }

    public boolean checkPageUrl(String pageName){
        return new WebDriverWait(driver, 20).until(ExpectedConditions.urlContains(pageName));
    }

    public boolean isElementPresent(By locator) {
        return driver.findElements(locator).size() > 0; //тру или фолс, элемент есть или нет
    }

    public void returnToHomePage() throws InterruptedException {
        click(By.cssSelector("[name='house']"));
        click(By.xpath("//*[@name='house']/.."));
        Thread.sleep(4000);
    }

    public void confirm() {
        click(By.cssSelector(".js-confirm"));
    }

    public void takeScreenshot(long timeMillis){
        File tmp = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        File screenshoot = new File("C:\\Users\\varuw\\Documents\\GitHub\\QA23Varvara\\trello-web-tests\\log\\screenshots\\screen"+timeMillis+".png");

        try {
            Files.copy(tmp, screenshoot);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
