package org.hw2;

import org.hw2.Pages.MainPage;
import org.hw2.Pages.UserPage;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TestUserPublishPost extends BaseTest {

    MainPage mainPage;
    UserPage userPage;

    @BeforeEach
    public void createPages() {
        mainPage = new MainPage();
        userPage = new UserPage();
        mainPage.open();
    }

    @Test
    public void userPublishPost() {
        String textInPost = "My beautiful post!";
        mainPage.publishPost(textInPost)
                .shouldHavePostWith(textInPost);
    }

    @AfterEach
    public void clearPage() {
        userPage.openWithoutLogin()
                .deleteLastPost();
    }
}
