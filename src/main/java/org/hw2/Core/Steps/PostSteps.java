package org.hw2.Core.Steps;

import com.codeborne.selenide.Selenide;
import org.hw2.Core.Pages.MainPage;
import org.hw2.Core.Pages.UserPage;

public class PostSteps extends LoginSteps {
    MainPage mainPage;
    UserPage userPage;

    public void loginBotPublishPostGoToUserPage() {
        mainPage = this.loginBot();
        mainPage
                .postNoteAndReturnMessage();
        mainPage
                .goToUserPage();
        Selenide.refresh();
    }

    public void goToUserPageDeleteLAstPost() {
        userPage = new MainPage()
                .goToUserPage();
        Selenide.refresh();
        userPage
                .deleteLastPost();
    }

    public void deletePost() {
        new UserPage()
                .deleteLastPost();
    }
}
