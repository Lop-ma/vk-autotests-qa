package org.hw2.Tests;

import org.hw2.BaseTest;
import org.hw2.Core.Pages.LoginPage;
import org.hw2.Core.ValueObjects.User;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class TestLogin extends BaseTest {
    LoginPage loginPage;
    User user;

    @BeforeEach
    public void createLoginPage() {
        loginPage = new LoginPage();
    }

    @Test
    @DisplayName("Test login to ok.ru with correct data")
    @Tag("login")
    public void testSuccessLogin() {
        user = new User();

        String expectedResult = "technopol68 technopol68";
        String actualResult = loginPage
                .login(user)
                .getShouldHaveName();
        String errorMessage = "Login user failed";

        Assertions.assertEquals(expectedResult, actualResult, errorMessage);
    }

    @ParameterizedTest
    @CsvSource({
            "++++++++, ++++++++, Неправильно указан логин и/или пароль, Wrong error when user sent incorrect login and incorrect password",
            "technopol68, , Введите пароль, Wrong error when user sent exist login and empty password",
            ", ++++++++, Введите логин, Wrong error when user sent empty login and exist password",
            "technopol68, technopolisPPPPPPPassword, Неправильно указан логин и/или пароль, Wrong error when user sent exist login and incorrect password",
            "technopolllllll68, technopolisPassword, Неправильно указан логин и/или пароль, Wrong error when user sent incorrect login and exist password",
    })
    @DisplayName("Test login to ok.ru with incorrect data")
    @Tag("login")
    public void testFailLogin(String login, String password, String expectedResult, String errorMessage) {
        user = new User(login, password);

        String actualResult = loginPage
                .failLogin(user);
        Assertions.assertEquals(expectedResult, actualResult, errorMessage);
    }
}
