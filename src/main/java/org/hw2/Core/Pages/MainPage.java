package org.hw2.Core.Pages;

import org.hw2.Core.Loadable.LoadablePage;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.enabled;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class MainPage extends LoadablePage {
    private static final By NAVIGATION_MENU = By.xpath(".//*[@role='navigation']/div");
    private static final By MOMENTS = By.xpath(".//button[@data-l='t,to_moments']");
    private static final By HOBBIES = By.xpath(".//button[@data-l='t,to_hobbies']");
    private static final By USER_AVATAR = By.xpath(".//div[@id='hook_Block_Avatar']");
    private static final By FRIENDS_ONLINE = By.xpath(".//div[@id='online-fr_block']");
    private static final By USER_NAME = By.xpath(".//a[@data-l='t,userPage']");

    private static final String NAVIGATION_MENU_ON_MAIN_PAGE = "Navigation menu should be enabled on Main page";
    private static final String MOMENTS_ON_MAIN_PAGE = "Block with moments should be enabled on Main page";
    private static final String HOBBIES_ON_MAIN_PAGE = "Block with hobbies should be enabled on Main page";
    private static final String USER_AVATAR_ON_MAIN_PAGE = "User avatar should be enabled on Main page";
    private static final String FRIENDS_ONLINE_ON_MAIN_PAGE = "Block with friends online should be enabled on Main page";
    private static final String USER_NAME_FOR_GET_NAME = "User name should be enabled for get name";

    public MainPage() {
        this.checkPage();
    }

    @Override
    public MainPage checkPage() {
        $(NAVIGATION_MENU)
                .shouldBe(enabled.because(NAVIGATION_MENU_ON_MAIN_PAGE));
        $(MOMENTS)
                .shouldBe(enabled.because(MOMENTS_ON_MAIN_PAGE));
        $(HOBBIES)
                .shouldBe(enabled.because(HOBBIES_ON_MAIN_PAGE));
        $(USER_AVATAR)
                .shouldBe(enabled.because(USER_AVATAR_ON_MAIN_PAGE));
        $(FRIENDS_ONLINE)
                .shouldBe(enabled.because(FRIENDS_ONLINE_ON_MAIN_PAGE));
        return this;
    }

    public String getShouldHaveName() {
        return $(USER_NAME)
                .shouldHave(visible.because(USER_NAME_FOR_GET_NAME))
                .getText();
    }
}
