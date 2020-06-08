package com.trello.mobile.manager;

import com.trello.mobile.tests.TestBase;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.HashSet;
import java.util.List;

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

    public void getBoardsList() {
        List<WebElement> boards = driver.findElements(By.xpath("//*[@resource-id='com.trello:id/board_name']"));
        for (WebElement board : boards) {
            String name = board.getText();
            System.out.println(name);
        }
    }

    public int getBoardsCountFromList() {
        List<WebElement> boards = driver.findElements(By.xpath("//*[@resource-id='com.trello:id/board_name']"));
        for (WebElement board : boards) {
            String name = board.getText();
            System.out.println(name);
        }
        return boards.size() - 1;
    }

}
