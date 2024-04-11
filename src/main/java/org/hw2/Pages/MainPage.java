package org.hw2.Pages;

import com.codeborne.selenide.Selenide;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.enabled;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;

public class MainPage {
    private final String XPATH_USER_NAME = ".//*[@id=\"hook_Block_Navigation\"]/div/div/div[1]/a";
    private final String XPATH_PUBLISH_BUTTON = ".//*[@id=\"hook_Block_PostingFormDropdown\"]/posting-form-dropdown/div/button";
    private final String XPATH_PUBLISH_NOTE = ".//*[@class=\"item-container__7e56q\"]";
    private final String XPATH_INPUT_FOR_NOTE = ".//*[@id=\"hook_Block_pfnull\"]/section/div[2]/div[1]/div/div/div[2]";
    private final String XPATH_POSTING_BUTTON = ".//*[@class=\"posting_footer js-posting-footer\"]/div/div/div/div[5]/div[2]/button";
    private final String XPATH_POST_TEXT = ".//*[@class=\"feed_b\"]";

    public MainPage open() {
        Selenide.open("/");
        LoginPage loginPage = new LoginPage();
        loginPage.login();
        return this;
    }

    public MainPage publishPost(String textInPost) {
        $(By.xpath(XPATH_PUBLISH_BUTTON)).shouldBe(enabled).click();
        $(By.xpath(XPATH_PUBLISH_NOTE)).shouldBe(enabled).click();
        $(By.xpath(XPATH_INPUT_FOR_NOTE)).shouldBe(enabled).val(textInPost);
        $(By.xpath(XPATH_POSTING_BUTTON)).shouldBe(enabled).click();
        return this;
    }

    public MainPage shouldHaveName(String name) {
        $(By.xpath(XPATH_USER_NAME)).shouldHave(text(name));
        return this;
    }

    public MainPage shouldHavePostWith(String textInPost) {
        $(By.xpath(XPATH_POST_TEXT)).shouldBe(text(textInPost));
        return this;
    }
}
