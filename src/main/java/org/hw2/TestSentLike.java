package org.hw2;

import org.hw2.Pages.MainPage;
import org.hw2.Pages.UserPage;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TestSentLike extends BaseTest {
    MainPage mainPage;
    UserPage userPage;

    @BeforeEach
    public void setUp() {
        mainPage = new MainPage();
        userPage = new UserPage();
        mainPage.open();

        String textInPost = "Some text";
        mainPage.publishPost(textInPost);
    }

    @Test
    public void sentLike() {
        userPage.openWithoutLogin()
                .likeLastPost()
                .shouldHaveLikeOnLastPost();
    }

    @AfterEach
    public void clearPAge() {
        userPage.deleteLastPost();
    }
}
