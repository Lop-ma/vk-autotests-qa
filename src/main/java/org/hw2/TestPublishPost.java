package org.hw2;

import com.codeborne.selenide.Selenide;
import org.hw2.Core.Pages.MainPage;
import org.hw2.Core.Pages.UserPage;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

public class TestPublishPost extends BeforeTestLogin {
    MainPage mainPage;
    UserPage userPage;

    @BeforeEach
    public void createMainPage() {
        mainPage = new MainPage();
    }

    @Test
    @DisplayName("Test publish post with note from Main page")
    @Tag("post")
    public void testSuccessPublishPost() {
        String expectedResult = "Заметка опубликована";
        String actualResult = mainPage.publishPost().getShouldHavePostMessage();
        String errorMessage = "Post note from Main page failed";
        Assertions.assertEquals(expectedResult, actualResult, errorMessage);
    }

    @AfterEach
    public void clearUserPage() {
        userPage = mainPage.openUserPage();
        Selenide.refresh();
        userPage.deleteLastPost();
    }
}
