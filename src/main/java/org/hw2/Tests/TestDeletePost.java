package org.hw2.Tests;

import org.hw2.BaseTest;
import org.hw2.Core.Pages.UserPage;
import org.hw2.Core.Steps.PostSteps;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

public class TestDeletePost extends BaseTest {
    PostSteps steps = new PostSteps();
    UserPage userPage;

    @BeforeEach
    public void createMainPage() {
        steps
                .loginBotPublishPostGoToUserPage();
        userPage = new UserPage();
    }

    @Test
    @DisplayName("Test delete first post in User page")
    @Tag("post")
    public void testSuccessDeletePost() {
        String expectedResult = "Тема удалена";
        String actualResult = userPage
                .deleteLastPost()
                .getTextDeleteMessage();
        String errorMessage = "Delete last post from User page failed";

        Assertions.assertEquals(expectedResult, actualResult, errorMessage);
    }
}
