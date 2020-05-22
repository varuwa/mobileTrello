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
        type(By.id("user"), userEmail);
        type(By.id("password"), password);
    }
    public void confirmLogin() {
        click(By.id("authenticate"));
    }
}
