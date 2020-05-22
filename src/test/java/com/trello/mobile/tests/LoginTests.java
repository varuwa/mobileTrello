package com.trello.mobile.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTests extends TestBase {

    @Test
    public void testLogin(){
        app.getSession().initLogin();
        app.getSession().fillLoginForm("varuwa@gmail.com", "trellobarbara");
        app.getSession().confirmLogin();
        Assert.assertEquals("toolbar", "toolbar");
    }
}
