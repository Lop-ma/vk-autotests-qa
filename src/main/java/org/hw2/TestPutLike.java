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

public class TestPutLike extends BeforeTestLogin {

    MainPage mainPage;
    UserPage userPage;

    @BeforeEach
    public void createMainPage() {
        mainPage = new MainPage();
        String textInPost = "Some text";
        mainPage.publishPost(textInPost);

        Selenide.sleep(1000);
        userPage = new UserPage();
    }

    @Test
    @DisplayName("Test like post on User page")
    @Tag("post")
    @Tag("like")
    public void testSuccessPutLike() {
        boolean actualResult = userPage.likeLastPost().shouldHaveLikeOnLastPost();
        String errorMessage = "Put like on last post user failed";
        Assertions.assertTrue(actualResult, errorMessage);
    }

    @AfterEach
    public void clearUserPage() {
        userPage.deleteLastPost();
    }
}
