package com.trello.mobile.manager;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SessionHelper extends HelperBase{

    public SessionHelper(AppiumDriver driver) {
        super(driver);
    }

    public void login(String userEmail, String password) {
        initLogin();
        fillLoginForm(userEmail, password);
        confirmLogin();

    }
    public void initLogin() {
        click(By.id("log_in_button"));
    }

    public void fillLoginForm(String userEmail, String password) {
        typeEmail(userEmail);
        typePassword(password);
    }

    private void typePassword(String password) {
        type(By.id("password"), password);
    }

    private void typeEmail(String userEmail) {
        type(By.id("user"), userEmail);
    }

    public void confirmLogin() {
        click(By.id("authenticate"));
    }
}
