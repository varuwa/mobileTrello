package com.trello.mobile.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class BoardsNameTest extends TestBase {
    @Test
    public void getBoardsName(){
        app.getSession().login("varuwa@gmail.com", "trellobarbara");

        int count = 0;
        do {
            app.getBoard().getBoardsList();
            app.getBoard().swipeBoardsPageUp();
            count++;
        }
        while (count == 5);

//        for(int i = 0; i < 8; i++) {
//            app.getBoard().getBoardsList();
//            if(i == 7){
//                app.getBoard().swipeBoardsPageUp();
//                i = 0;
//            }
//        }

    }

}
