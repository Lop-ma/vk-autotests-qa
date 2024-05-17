package org.hw2.Core.Pages;

import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.enabled;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class UserPage extends BasePage {
    private static final By ACTIVE_MENU_NAME = By.xpath(".//a[@data-l='t,userPage' and contains(@class, 'ac')]");
    private static final By PROFILE_USER_NAME = By.xpath(".//a[@class='profile-user-info_name']");
    private static final By USER_AVATAR = By.xpath(".//div[@class='entity-avatar']");
    private static final By ABOUT_USER = By.xpath(".//div[contains(@id, 'AboutUser')]");
    private static final By FAVORITE_PHOTOS = By.xpath(".//div[contains(@id, 'FavoritePhotos')]");
    private static final By FIRST_POST_MENU = By.xpath(".//div[@class='feed-action']");
    private static final By DELETE_POST_BUTTON = By.xpath(".//div[text()='Удалить заметку']");
    private static final By CONFIRM_DELETE = By.xpath(".//a[contains(@class, 'form-actions_yes')]");
    private static final By DELETE_MESSAGE = By.xpath(".//div[@class='delete-stub_ac']");
    private static final By LIKE_BUTTON = By.xpath(".//li[@data-widget-item-type='like']");
    private static final By ACTIVE_LIKE = By.xpath(".//span[@data-l='t,unlike']");

    private static final String MENU_NAME_ON_USER_PAGE = "Menu button with user name should be enabled and active on User page";
    private static final String PROFILE_USER_NAME_ON_USER_PAGE = "Profile user name should be visible on User page";
    private static final String USER_AVATAR_ON_USER_PAGE = "User avatar should be enabled on User page";
    private static final String ABOUT_USER_ON_USER_PAGE = "Block about user should be enabled on User page";
    private static final String FAVORITE_PHOTOS_ON_USER_PAGE = "Block with favorite photos should be enabled on User page";
    private static final String POST_MENU_FOR_DELETE_POST = "Post menu should be enabled on firs post for delete first post";
    private static final String DELETE_BUTTON_FOR_DELETE_POST = "Delete button should be enabled for delete post";
    private static final String BUTTON_CONFIRM_FOR_DELETE_POST = "Button confirm delete should be enabled for delete post";
    private static final String LIKE_BUTTON_FOR_PUT_LIKE = "Like button should be enabled for put like on last post";
    private static final String DELETE_MESSAGE_FOR_CHECK_DELETE = "Delete message should be enabled for check delete post";
    private static final String ACTIVE_LIKE_FOR_CHECK_PUT_LIKE = "Active like button should be enabled for check put like on last post";

    public UserPage() {
        this.checkPage();
    }

    @Override
    public UserPage checkPage() {
        $(ACTIVE_MENU_NAME).shouldBe(enabled.because(MENU_NAME_ON_USER_PAGE));
        $(PROFILE_USER_NAME).shouldBe(visible.because(PROFILE_USER_NAME_ON_USER_PAGE));
        $(USER_AVATAR).shouldBe(enabled.because(USER_AVATAR_ON_USER_PAGE));
        $(ABOUT_USER).shouldBe(enabled.because(ABOUT_USER_ON_USER_PAGE));
        $(FAVORITE_PHOTOS).shouldBe(enabled.because(FAVORITE_PHOTOS_ON_USER_PAGE));
        return this;
    }

    public UserPage deleteLastPost() {
        $(FIRST_POST_MENU).shouldBe(enabled.because(POST_MENU_FOR_DELETE_POST)).hover();
        $(DELETE_POST_BUTTON).shouldBe(enabled.because(DELETE_BUTTON_FOR_DELETE_POST)).click();
        $(CONFIRM_DELETE).shouldBe(enabled.because(BUTTON_CONFIRM_FOR_DELETE_POST)).click();
        return this;
    }

    public UserPage likeLastPost() {
        $(LIKE_BUTTON).shouldBe(enabled.because(LIKE_BUTTON_FOR_PUT_LIKE)).click();
        return this;
    }

    public String getTextDeleteMessage() {
        return $(DELETE_MESSAGE).shouldHave(visible.because(DELETE_MESSAGE_FOR_CHECK_DELETE)).getText();
    }

    public boolean shouldHaveLikeOnLastPost() {
        $(ACTIVE_LIKE).shouldBe(enabled.because(ACTIVE_LIKE_FOR_CHECK_PUT_LIKE));
        return true;
    }
}
