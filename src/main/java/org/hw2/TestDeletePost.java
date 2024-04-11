package org.hw2;

import com.codeborne.selenide.Selenide;
import org.hw2.Core.Pages.MainPage;
import org.hw2.Core.Pages.UserPage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

public class TestDeletePost extends BeforeTestLogin {
    MainPage mainPage;
    UserPage userPage;

    @BeforeEach
    public void createMainPage() {
        mainPage = new MainPage();
        String textInPost = "Post for delete :(";
        mainPage.publishPost(textInPost);

        Selenide.sleep(1000);
        userPage = new UserPage();
    }

    @Test
    @DisplayName("Test delete first post in User page")
    @Tag("post")
    public void testSuccessDeletePost() {
        String expectedResult = "Тема удалена";
        String actualResult = userPage.deleteLastPost().getTextDeleteMessage();
        String errorMessage = "Delete last post from User page failed";
        Assertions.assertEquals(expectedResult, actualResult, errorMessage);
    }
}
