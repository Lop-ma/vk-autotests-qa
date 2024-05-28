package org.hw2.Tests;

import org.hw2.BaseTest;
import org.hw2.Core.Pages.UserPage;
import org.hw2.Core.Steps.PostSteps;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

public class TestPutLike extends BaseTest {
    PostSteps steps = new PostSteps();
    UserPage userPage;

    @BeforeEach
    public void createMainPage() {
        steps
                .loginBotPublishPostGoToUserPage();
        userPage = new UserPage();
    }

    @Test
    @DisplayName("Test like post on User page")
    @Tag("post")
    @Tag("like")
    public void testSuccessPutLike() {
        boolean actualResult = userPage
                .likeLastPost()
                .shouldHaveLikeOnLastPost();
        String errorMessage = "Put like on last post user failed";
        Assertions.assertTrue(actualResult, errorMessage);
    }

    @AfterEach
    public void clearUserPage() {
        steps
                .deletePost();
    }
}
