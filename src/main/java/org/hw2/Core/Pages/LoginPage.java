package org.hw2.Core.Pages;

import com.codeborne.selenide.Selenide;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.enabled;
import static com.codeborne.selenide.Selenide.$;

public class LoginPage extends BasePage {
    private static final By INPUT_LOGIN = By.xpath(".//*[@id='field_email']");
    private static final By INPUT_PASSWORD = By.xpath(".//*[@id='field_password']");
    private static final By LOGIN_BUTTON = By.xpath(".//*[@data-l='t,sign_in']");
    private static final String LOGIN = "technopol68";
    private static final String PASSWORD = "technopolisPassword";

    private static final String INPUT_LOGIN_ON_LOGIN_PAGE = "Login input field should be enabled on Login page";
    private static final String INPUT_LOGIN_SET_VALUE = "Login input field should be enabled for enter login";
    private static final String INPUT_PASSWORD_ON_LOGIN_PAGE = "Password input field should be enabled on Login page";
    private static final String INPUT_PASSWORD_SET_VALUE = "Password input field should be enabled for enter login";
    private static final String LOGIN_BUTTON_ON_LOGIN_PAGE = "Login button should be enabled on Login page";
    private static final String LOGIN_BUTTON_CLICK = "Login button should be enabled for click";

    public LoginPage() {
        this.open().checkPage();
    }

    @Override
    public LoginPage checkPage() {
        $(INPUT_LOGIN).shouldBe(enabled.because(INPUT_LOGIN_ON_LOGIN_PAGE));
        $(INPUT_PASSWORD).shouldBe(enabled.because(INPUT_PASSWORD_ON_LOGIN_PAGE));
        $(LOGIN_BUTTON).shouldBe(enabled.because(LOGIN_BUTTON_ON_LOGIN_PAGE));
        return this;
    }

    @Override
    public LoginPage open() {
        Selenide.open("/");
        return this;
    }

    public MainPage login() {
        $(INPUT_LOGIN).shouldBe(enabled.because(INPUT_LOGIN_SET_VALUE)).setValue(LOGIN);
        $(INPUT_PASSWORD).shouldBe(enabled.because(INPUT_PASSWORD_SET_VALUE)).setValue(PASSWORD);
        $(LOGIN_BUTTON).shouldBe(enabled.because(LOGIN_BUTTON_CLICK)).click();
        return new MainPage();
    }
}
