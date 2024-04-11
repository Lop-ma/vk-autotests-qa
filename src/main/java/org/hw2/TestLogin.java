package org.hw2;

import org.hw2.Core.Pages.LoginPage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

public class TestLogin extends BaseTest {
    LoginPage loginPage;

    @BeforeEach
    public void createLoginPage() {
        loginPage = new LoginPage();
    }

    @Test
    @DisplayName("Test login to ok.ru with correct data")
    @Tag("login")
    public void testSuccessLogin() {
        String expectedResult = "technopol68 technopol68";
        String actualResult = loginPage.login().getShouldHaveName();
        String errorMessage = "Login user failed";
        Assertions.assertEquals(expectedResult, actualResult, errorMessage);
    }
}
