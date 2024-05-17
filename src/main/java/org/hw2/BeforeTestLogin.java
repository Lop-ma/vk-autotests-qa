package org.hw2;

import org.hw2.Core.Pages.LoginPage;
import org.junit.jupiter.api.BeforeEach;

public class BeforeTestLogin extends BaseTest {
    LoginPage loginPage;

    @BeforeEach
    public void UserLogin() {
        loginPage = new LoginPage();
        loginPage.login();
    }
}
