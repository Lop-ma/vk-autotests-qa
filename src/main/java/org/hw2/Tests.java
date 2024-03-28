package org.hw2;

import com.codeborne.selenide.Configuration;
import org.hw2.Pages.GroupPage;
import org.hw2.Pages.LoginPage;
import org.hw2.Pages.MainPage;
import org.hw2.Pages.UserPage;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import com.codeborne.selenide.Selenide;

public class Tests {

    @BeforeAll
    public static void setup() {
        Configuration.baseUrl = "https://ok.ru/";
        Configuration.browser = "chrome";
    }

    @Test
    public void userLogin() {
        LoginPage loginPage = new LoginPage();
        MainPage mainPage = new MainPage();

        loginPage.open()
                .login();
        mainPage.shouldHaveName("technopol68");
    }

    @Test
    public void userPublishPost() {
        MainPage mainPage = new MainPage();
        UserPage userPage = new UserPage();
        mainPage.open();

        String textInPost = "My beautiful post!";
        mainPage.publishPost(textInPost)
                .shouldHavePostWith(textInPost);

        userPage.openWithoutLogin()
                .deleteLastPost();
    }

    @Test
    public void userDeletePost() {
        MainPage mainPage = new MainPage();
        UserPage userPage = new UserPage();
        mainPage.open();

        String textInPost = "Post for delete :(";
        mainPage.publishPost(textInPost);

        userPage.openWithoutLogin()
                .deleteLastPost()
                .shouldHaveDeleteMessage();
    }

    @Test
    public void renameGroup() {
        GroupPage groupPage = new GroupPage();
        groupPage.openGroup();

        String oldName = groupPage.getName();
        String newName = "NewName";
        if (oldName.equals(newName)) {
            newName = "SuperNewName";
        }

        groupPage.rename(newName)
                .shouldHaveName(newName);

        groupPage.rename(oldName);
    }

    @Test
    public void sentLike() {
        MainPage mainPage = new MainPage();
        UserPage userPage = new UserPage();
        mainPage.open();

        String textInPost = "Some text";
        mainPage.publishPost(textInPost);

        userPage.openWithoutLogin()
                .likeLastPost()
                .shouldHaveLikeOnLastPost();

        userPage.deleteLastPost();
    }

    @AfterEach
    public void close() {
        Selenide.closeWebDriver();
    }
}
