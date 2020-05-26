package com.trello.mobile.tests;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class BoardsNameTest extends TestBase {
    @Test
    public void getBoardsName(){
        app.getSession().login("varuwa@gmail.com", "trellobarbara");
        for(int i = 0; i < 100; i++){
            String boardName = app.getBoard().getNameOfBoard();
            System.out.println(boardName);
            app.getBoard().swipeBoardsPageUp();
        }

    }
}
