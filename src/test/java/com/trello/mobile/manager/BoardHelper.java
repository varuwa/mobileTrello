package com.trello.mobile.manager;

import com.trello.mobile.tests.TestBase;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;

public class BoardHelper extends HelperBase {
    public BoardHelper(AppiumDriver driver) {
        super(driver);
    }

    public String getNameOfBoard() {
        return driver.findElement(By.xpath("//*[@resource-id='com.trello:id/board_name']")).getText();
    }

    public void swipeBoardsPageUp() {
        swipeUp();
    }

}
