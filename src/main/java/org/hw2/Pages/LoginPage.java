package org.hw2.Pages;

import com.codeborne.selenide.Selenide;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.enabled;
import static com.codeborne.selenide.Selenide.$;

public class LoginPage {
    private final String XPATH_LOGIN = ".//*[@id=\"field_email\"]";
    private final String XPATH_PASSWORD = ".//*[@id=\"field_password\"]";
    private final String XPATH_REGISTRATION_BUTTON = ".//*[@class=\"button-pro __wide\"]";
    private final String LOGIN = "technopol68";
    private final String PASSWORD = "technopolisPassword";

    public LoginPage open() {
        Selenide.open("/");
        return this;
    }

    public LoginPage login() {
        $(By.xpath(XPATH_LOGIN)).shouldBe(enabled).val(LOGIN);
        $(By.xpath(XPATH_PASSWORD)).shouldBe(enabled).val(PASSWORD);
        $(By.xpath(XPATH_REGISTRATION_BUTTON)).shouldBe(enabled).click();
        return this;
    }
}
