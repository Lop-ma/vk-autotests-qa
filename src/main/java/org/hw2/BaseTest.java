package org.hw2;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;

public class BaseTest {
    @BeforeAll
    public static void setup() {
        Configuration.baseUrl = "https://ok.ru";
        Configuration.browser = "chrome";
    }

    @AfterEach
    public void close() {
        Selenide.closeWebDriver();
    }
}
