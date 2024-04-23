package org.hw2;

import org.hw2.Pages.LoginPage;
import org.hw2.Pages.MainPage;
import org.junit.jupiter.api.Test;

public class TestUserLogin extends BaseTest {
    @Test
    public void userLogin() {
        LoginPage loginPage = new LoginPage();
        MainPage mainPage = new MainPage();

        loginPage.open()
                .login();
        mainPage.shouldHaveName("technopol68");
    }
}
