package org.hw2.Tests;

import org.hw2.BaseTest;
import org.hw2.Core.Pages.MainPage;
import org.hw2.Core.Steps.PostSteps;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

public class TestPublishPost extends BaseTest {
    PostSteps steps = new PostSteps();
    MainPage mainPage;

    @BeforeEach
    public void createMainPage() {
        mainPage = steps
                .loginBot();
    }

    @Test
    @DisplayName("Test publish post with note from Main page")
    @Tag("post")
    public void testSuccessPublishPost() {
        String expectedResult = "Заметка опубликована";
        String actualResult = mainPage
                .postNoteAndReturnMessage();
        String errorMessage = "Post note from Main page failed";

        Assertions.assertEquals(expectedResult, actualResult, errorMessage);
    }

    @AfterEach
    public void clearUserPage() {
        steps
                .goToUserPageDeleteLAstPost();
    }
}
