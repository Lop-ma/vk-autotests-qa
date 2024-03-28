package org.hw2.Pages;

import com.codeborne.selenide.Selenide;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.enabled;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;

public class UserPage {
    private final String XPATH_USER_PAGE = ".//*[@id=\"hook_Block_Navigation\"]/div/div/div[1]/a";
    private final String XPATH_THREE_DOTS = ".//*[@class=\"feed-actions-w\"]/div";
    private final String XPATH_DELETE_POST_BUTTON = ".//*[@class=\"posR\"]/div/ul/li[4]/a";
    private final String XPATH_CONFIRM_DELETE = ".//*[@class=\"button-pro __small form-actions_yes\"]";
    private final String XPATH_DELETE_MESSAGE = ".//*[@class=\"delete-stub_ac\"]";
    private final String XPATH_LIKE_BUTTON = ".//*[@class=\"feed-list __compact\"]/div[1]/div/div[2]/div[3]/ul/li[3]";
    private final String XPATH_COUNT_LIKE = ".//*[@class=\"feed-list __compact\"]/div[1]/div/div[2]/div[3]/div/div/div";
    public UserPage open() {
        Selenide.open("/");
        LoginPage loginPage = new LoginPage();
        loginPage.login();
        $(By.xpath(XPATH_USER_PAGE)).shouldBe(enabled).click();
        return this;
    }

    public UserPage openWithoutLogin() {
        Selenide.open("/");
        $(By.xpath(XPATH_USER_PAGE)).shouldBe(enabled).click();
        return this;
    }

    public UserPage deleteLastPost() {
        $(By.xpath(XPATH_THREE_DOTS)).should(enabled).hover();
        $(By.xpath(XPATH_DELETE_POST_BUTTON)).should(enabled).click();
        $(By.xpath(XPATH_CONFIRM_DELETE)).should(enabled).click();
        return this;
    }

    public UserPage likeLastPost() {
        $(By.xpath(XPATH_LIKE_BUTTON)).shouldBe(enabled).click();
        return this;
    }

    public UserPage shouldHaveDeleteMessage() {
        $(By.xpath(XPATH_DELETE_MESSAGE)).shouldHave(text("Тема удалена"));
        return this;
    }

    public UserPage shouldHaveLikeOnLastPost() {
        $(By.xpath(XPATH_COUNT_LIKE)).shouldHave(text("1 класс"));
        return this;
    }
}
