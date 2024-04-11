package org.hw2.Core.Pages;

import com.codeborne.selenide.Selenide;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.enabled;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class MainPage extends BasePage {
    private static final String URL_MAIN_PAGE = "/feed";
    private static final By ACTIVE_MENU_FEED = By.xpath(".//a[@data-l='t,userMain' and contains(@class, 'ac')]");
    private static final By MOMENTS = By.xpath(".//button[@data-l='t,to_moments']");
    private static final By HOBBIES = By.xpath(".//button[@data-l='t,to_hobbies']");
    private static final By USER_AVATAR = By.xpath(".//div[@id='hook_Block_Avatar']");
    private static final By FRIENDS_ONLINE = By.xpath(".//div[@id='online-fr_block']");
    private static final By USER_NAME = By.xpath(".//a[@data-l='t,userPage']");
    private static final By PUBLISH_BUTTON = By.xpath(".//button[@data-l='t,pf_dropdown']");
    private static final By PUBLISH_NOTE = By.xpath(".//span[@data-l='t,feed.posting.ui.input']");
    private static final By INPUT_FOR_NOTE = By.xpath(".//div[contains(@class, 'ok-posting-handler')]");
    private static final By POSTING_BUTTON = By.xpath(".//button[@data-l='t,button.submit']");
    private static final By PUBLICATION_MESSAGE = By.xpath(".//div[@class='tip-block_cnt']");

    private static final String MENU_FEED_ON_MAIN_PAGE = "Feed button should be enabled and active on Main page";
    private static final String MOMENTS_ON_MAIN_PAGE = "Block with moments should be enabled on Main page";
    private static final String HOBBIES_ON_MAIN_PAGE = "Block with hobbies should be enabled on Main page";
    private static final String USER_AVATAR_ON_MAIN_PAGE = "User avatar should be enabled on Main page";
    private static final String FRIENDS_ONLINE_ON_MAIN_PAGE = "Block with friends online should be enabled on Main page";
    private static final String PUBLISH_BUTTON_FOR_POST_NOTE = "Publish button should be enabled for post note";
    private static final String PUBLISH_NOTE_BUTTON_FOR_POST_NOTE = "Publish note button should be enabled for post note";
    private static final String INPUT_FOR_POST_NOTE = "Note input field should be enabled in posting field for post note";
    private static final String INPUT_FOR_NOTE_FOR_SET_VALUE = "Note input field should be enabled in posting field for enter note text";
    private static final String POSTING_BUTTON_FOR_POST_NOTE = "Posting button should be enabled for post note";
    private static final String USER_NAME_FOR_GET_NAME = "User name should be enabled for get name";
    private static final String PUBLICATION_MESSAGE_FOR_GET_TEXT = "Publication message should be enabled for get text";

    public MainPage() {
        try {
            this.checkPage();
        } catch (IllegalStateException e) {
            this.open().checkPage();
        }
    }

    @Override
    public MainPage checkPage() {
        $(ACTIVE_MENU_FEED).shouldBe(enabled.because(MENU_FEED_ON_MAIN_PAGE));
        $(MOMENTS).shouldBe(enabled.because(MOMENTS_ON_MAIN_PAGE));
        $(HOBBIES).shouldBe(enabled.because(HOBBIES_ON_MAIN_PAGE));
        $(USER_AVATAR).shouldBe(enabled.because(USER_AVATAR_ON_MAIN_PAGE));
        $(FRIENDS_ONLINE).shouldBe(enabled.because(FRIENDS_ONLINE_ON_MAIN_PAGE));
        return this;
    }

    @Override
    public MainPage open() {
        Selenide.open(URL_MAIN_PAGE);
        return this;
    }

    public MainPage publishPost(String textInPost) {
        $(PUBLISH_BUTTON).shouldBe(enabled.because(PUBLISH_BUTTON_FOR_POST_NOTE)).click();
        $(PUBLISH_NOTE).shouldBe(enabled.because(PUBLISH_NOTE_BUTTON_FOR_POST_NOTE)).click();
        $(INPUT_FOR_NOTE).shouldBe(enabled.because(INPUT_FOR_POST_NOTE)).click();
        $(INPUT_FOR_NOTE).shouldBe(enabled.because(INPUT_FOR_NOTE_FOR_SET_VALUE)).setValue(textInPost);
        $(POSTING_BUTTON).shouldBe(enabled.because(POSTING_BUTTON_FOR_POST_NOTE)).click();
        return this;
    }

    public String getShouldHaveName() {
        return $(USER_NAME).shouldHave(visible.because(USER_NAME_FOR_GET_NAME)).getText();
    }

    public String getShouldHavePostMessage() {
        return $(PUBLICATION_MESSAGE).shouldBe(visible.because(PUBLICATION_MESSAGE_FOR_GET_TEXT)).getText();
    }
}
