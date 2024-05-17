package org.hw2.Core.Pages;

import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.enabled;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class MainPage extends BasePage {
    private static final By ACTIVE_MENU_FEED = By.xpath(".//a[@data-l='t,userMain' and contains(@class, 'ac')]");
    private static final By MOMENTS = By.xpath(".//button[@data-l='t,to_moments']");
    private static final By HOBBIES = By.xpath(".//button[@data-l='t,to_hobbies']");
    private static final By USER_AVATAR = By.xpath(".//div[@id='hook_Block_Avatar']");
    private static final By FRIENDS_ONLINE = By.xpath(".//div[@id='online-fr_block']");
    private static final By USER_NAME = By.xpath(".//a[@data-l='t,userPage']");
    private static final By GROUPS = By.xpath(".//a[@data-l='t,userAltGroup']");
    private static final By SHOW_ALL = By.xpath(".//a[text()='Показать все']");
    private static final By TEST_GROUP = By.xpath(".//a[contains(@class, 'card_name') and contains(@href, '70000005781564')]");
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
    private static final String USER_NAME_OPEN_USER_PAGE = "Button with user name should be enabled for open user page";
    private static final String GROUPS_OPEN_TEST_GROUP = "Button Groups should be enabled for open group page";
    private static final String SHOW_ALL_OPEN_TEST_GROUP = "Button Show all should be enabled for open group page";
    private static final String NAME_TEST_GROUP_OPEN_TEST_GROUP = "Name test group should be enabled for open group page";
    private static final String PUBLISH_BUTTON_FOR_POST_NOTE = "Publish button should be enabled for post note";
    private static final String PUBLISH_NOTE_BUTTON_FOR_POST_NOTE = "Publish note button should be enabled for post note";
    private static final String INPUT_FOR_POST_NOTE = "Note input field should be enabled in posting field for post note";
    private static final String INPUT_FOR_NOTE_FOR_SET_VALUE = "Note input field should be enabled in posting field for enter note text";
    private static final String POSTING_BUTTON_FOR_POST_NOTE = "Posting button should be enabled for post note";
    private static final String USER_NAME_FOR_GET_NAME = "User name should be enabled for get name";
    private static final String PUBLICATION_MESSAGE_FOR_GET_TEXT = "Publication message should be enabled for get text";

    public MainPage() {
        this.checkPage();
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

    public UserPage openUserPage() {
        $(USER_NAME).shouldBe(enabled.because(USER_NAME_OPEN_USER_PAGE)).click();
        return new UserPage();
    }

    public GroupPage openTestGroup() {
        $(GROUPS).shouldBe(enabled.because(GROUPS_OPEN_TEST_GROUP)).click();
        $(SHOW_ALL).shouldBe(enabled.because(SHOW_ALL_OPEN_TEST_GROUP)).click();
        $(TEST_GROUP).shouldBe(enabled.because(NAME_TEST_GROUP_OPEN_TEST_GROUP)).click();
        return new GroupPage();
    }

    public MainPage publishPost() {
        String textInPost = "Some text";
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
