package com.trello.mobile.tests;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTests extends TestBase {

    @Test
    public void testLogin(){
        app.getSession().initLogin();
        app.getSession().fillLoginForm("varuwa@gmail.com", "trellobarbara");
        app.getSession().confirmLogin();
        Assert.assertTrue(app.getSession().isElementPresent(By.xpath("//*[@content-desc='Open Drawer']")));
    }
}
