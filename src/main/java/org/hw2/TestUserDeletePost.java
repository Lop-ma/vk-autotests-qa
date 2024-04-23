package org.hw2;

import org.hw2.Pages.MainPage;
import org.hw2.Pages.UserPage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TestUserDeletePost extends BaseTest {

    MainPage mainPage;
    UserPage userPage;

    @BeforeEach
    public void setUp() {
        mainPage = new MainPage();
        userPage = new UserPage();
        mainPage.open();

        String textInPost = "Post for delete :(";
        mainPage.publishPost(textInPost);
    }

    @Test
    public void userDeletePost() {
        userPage.openWithoutLogin()
                .deleteLastPost()
                .shouldHaveDeleteMessage();
    }
}
