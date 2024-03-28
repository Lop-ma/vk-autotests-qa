package org.hw2.Pages;

import com.codeborne.selenide.Selenide;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.enabled;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;

public class GroupPage {
    private final String GROUP_URL = "/group/70000005781564";
    private final String XPATH_GROUP_NAME = ".//*[@class=\"group-name_h\"]";
    private final String XPATH_THREE_DOT = ".//*[@id=\"hook_Block_AltGroupMainMenu\"]/ul/li[2]/div/button";
    private final String XPATH_SETTINGS = ".//*[@class=\"dropdown_cnt u-menu_lvl2 __show\"]/ul/li[2]";
    private final String XPATH_INPUT_NAME = ".//*[@id=\"field_name\"]";
    private final String XPATH_BUTTON_SAVE = ".//*[@id=\"hook_FormButton_button_save_settings\"]";
    private final String XPATH_BUTTON_CANCEL = ".//*[@id=\"group_settings_sticky_save\"]/div/div/div/a";

    public GroupPage openGroup() {
        Selenide.open("/");
        LoginPage loginPage = new LoginPage();
        loginPage.login();
        Selenide.open(GROUP_URL);
        return this;
    }

    public String getName() {
        return $(By.xpath(XPATH_GROUP_NAME)).getText();
    }

    private GroupPage openSettings() {
        $(By.xpath(XPATH_THREE_DOT)).shouldBe(enabled).click();
        $(By.xpath(XPATH_SETTINGS)).shouldBe(enabled).click();
        return this;
    }

    private GroupPage closeSettings() {
        $(By.xpath(XPATH_BUTTON_CANCEL)).shouldBe(enabled).click();
        return this;
    }
    public GroupPage rename(String newName) {
        openSettings();
        $(By.xpath(XPATH_INPUT_NAME)).shouldBe(enabled).doubleClick().val(newName);
        $(By.xpath(XPATH_BUTTON_SAVE)).shouldBe(enabled).click();
        closeSettings();
        return this;
    }

    public GroupPage shouldHaveName(String name) {
        $(By.xpath(XPATH_GROUP_NAME)).shouldHave(text(name));
        return this;
    }
}
