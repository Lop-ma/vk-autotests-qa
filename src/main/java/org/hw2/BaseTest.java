package org.hw2;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;

public class BaseTest {
    private static final String BASE_URL = "https://ok.ru/";
    private static final String BROWSER = "chrome";

    @BeforeAll
    public static void setUp() {
        Configuration.baseUrl = BASE_URL;
        Configuration.browser = BROWSER;
    }

    @AfterEach
    public void close() {
        Selenide.closeWebDriver();
    }
}
