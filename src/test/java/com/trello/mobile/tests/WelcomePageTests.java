package com.trello.mobile.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class WelcomePageTests extends TestBase {

    @Test
    public void swipePageTest(){
        for(int i = 0; i < 4; i++){
            String pageTitle = app.getWelcome().getPageTitle();
            System.out.println(pageTitle);
            Assert.assertTrue(app.getWelcome().isLoginButtonPresent());
            Assert.assertTrue(app.getWelcome().isSingUpButtonPresent());
            app.getWelcome().swipeWelcomePageToLeft();
        }
    }

    @Test
    public void swipeLeftAndRightPageTest(){
            String pageTitle1 = app.getWelcome().getPageTitle();
            System.out.println(pageTitle1);
            app.getWelcome().swipeWelcomePageToLeft();
            String pageTitle2 = app.getWelcome().getPageTitle();
            System.out.println(pageTitle2);
            app.getWelcome().swipeWelcomePageToLeft();
            String pageTitle3 = app.getWelcome().getPageTitle();
            System.out.println(pageTitle3);
            app.getWelcome().swipeWelcomePageToRight();
            String pageTitle4 = app.getWelcome().getPageTitle();
            System.out.println(pageTitle4);
            app.getWelcome().swipeWelcomePageToRight();
            String pageTitle5 = app.getWelcome().getPageTitle();
            System.out.println(pageTitle5);
    }

}
