package com.trello.mobile.manager;

import com.trello.mobile.tests.TestBase;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class ApplicationManager {
    AppiumDriver driver;
    DesiredCapabilities capabilities;
    BoardHelper board;
//    TeamHelper team;
    SessionHelper session;
    WelcomePage welcome;
//    ProfileHelper profile;
    String browser;
    Properties properties;


    public ApplicationManager(String browser) {
        this.browser = browser;
    }
    Logger logger = LoggerFactory.getLogger(ApplicationManager.class);

    public void init() throws IOException {
        capabilities = new DesiredCapabilities();
        capabilities.setCapability("platformName", "Android");
        capabilities.setCapability("deviceName", "QA23_Nexus5");
        capabilities.setCapability("platformVersion", "8.0");
        capabilities.setCapability("automationName", "Appium");
        capabilities.setCapability("appPackage", "com.trello");
        capabilities.setCapability("appActivity", ".home.HomeActivity");

        capabilities.setCapability("app", "C:/Users/varuw/Documents/GitHub/mobileTrello/apk/Trello_new.apk");

        driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities); //сервер Appium
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        logger.info("Ready!");
        //driver.manage().window().maximize();

        properties = new Properties();
        String target = System.getProperty("target", "android");
        //properties.load(new FileReader(new File(String.format("src/test/resources/%s.properties", target))));

        //driver.navigate().to(properties.getProperty("web.baseURL"));

        welcome = new WelcomePage(driver);
        session = new SessionHelper(driver);
        //session.login("varuwa@gmail.com", "trellobarbara");
        //session.login(properties.getProperty("web.user"), properties.getProperty("web.password"));

        //new WebDriverWait(driver, 20).until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("[data-test-id=header-member-menu-button]")));

        board = new BoardHelper(driver);
//        team = new TeamHelper(wd);
//        profile = new ProfileHelper(wd);

    }

    public void stop() {
        driver.quit();
        logger.info("Test finished");
    }


//    public BoardHelper getBoard() {
//        return board;
//    }
//
//    public TeamHelper getTeam() {
//        return team;
//    }

    public SessionHelper getSession() {
        return session;
    }

    public WelcomePage getWelcome() {
        return welcome;
    }

    public BoardHelper getBoard() {
        return board;
    }

    //    public ProfileHelper getProfile(){ return profile;}

}
