package org.hw2.Core.Pages;

import com.codeborne.selenide.Selenide;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.enabled;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class GroupPage extends BasePage {
    private static final String URL_GROUP_PAGE = "/group/70000005781564";
    private static final By GROUP_NAME = By.xpath(".//div[@class='group-name_t']");
    private static final By GROUP_CATEGORY = By.xpath(".//div[@class='group-name_info']");
    private static final By GROUP_AVATAR = By.xpath(".//div[@class='entity-avatar']");
    private static final By ABOUT_GROUP = By.xpath(".//div[@id='hook_Block_LeftColumnTopCardAltGroup']");
    private static final By GROUP_MEMBERS = By.xpath(".//div[@id='hook_Block_AltGroupMainMembersRB']");
    private static final By THREE_DOT_MENU = By.xpath(".//div[@data-toggle-selector='.toggle-dropdown']");
    private static final By GROUP_SETTINGS = By.xpath(".//a[@class='u-menu_a ' and text()='Настройки']");
    private static final By INPUT_NAME = By.xpath(".//input[@id='field_name']");
    private static final By SAVE_SETTINGS = By.xpath(".//*[@name='button_save_settings']");
    private static final By CANCEL_CHANGE = By.xpath(".//a[contains(@class, 'button-pro') and contains(text(), 'Отменить')]");

    private static final String GROUP_NAME_ON_GROUP_PAGE = "Group name should be visible on Group page";
    private static final String GROUP_NAME_FOR_GET_NAME = "Group name should be visible for get group name";
    private static final String GROUP_CATEGORY_ON_GROUP_PAGE = "Group category should be visible on Group page";
    private static final String GROUP_AVATAR_ON_GROUP_PAGE = "Group avatar should be enabled on Group page";
    private static final String ABOUT_GROUP_ON_GROUP_PAGE = "Block about group should be enabled on Group page";
    private static final String GROUP_MEMBERS_ON_GROUP_PAGE = "List group members should be enabled on Group page";
    private static final String THREE_DOT_MENU_FOR_OPEN_SETTINGS = "Three dot group menu should be enabled for open settings";
    private static final String GROUP_SETTINGS_FOR_OPEN_SETTINGS = "Button group settings should be enabled for open settings";
    private static final String CANCEL_CHANGE_FOR_CLOSE_SETTINGS = "Button cancel change in settings should be enabled for close settings";
    private static final String INPUT_NAME_FOR_RENAME_GROUP = "Name input field should be enabled for rename group";
    private static final String SAVE_SETTINGS_FOR_RENAME_GROUP = "Button save settings should be enabled for rename group";

    public GroupPage() {
        this.open().checkPage();
    }

    @Override
    public GroupPage checkPage() {
        $(GROUP_NAME).shouldBe(visible.because(GROUP_NAME_ON_GROUP_PAGE));
        $(GROUP_CATEGORY).shouldBe(visible.because(GROUP_CATEGORY_ON_GROUP_PAGE));
        $(GROUP_AVATAR).shouldBe(enabled.because(GROUP_AVATAR_ON_GROUP_PAGE));
        $(ABOUT_GROUP).shouldBe(enabled.because(ABOUT_GROUP_ON_GROUP_PAGE));
        $(GROUP_MEMBERS).shouldBe(enabled.because(GROUP_MEMBERS_ON_GROUP_PAGE));
        return this;
    }

    @Override
    public GroupPage open() {
        Selenide.open(URL_GROUP_PAGE);
        return this;
    }

    private void openSettings() {
        $(THREE_DOT_MENU).shouldBe(enabled.because(THREE_DOT_MENU_FOR_OPEN_SETTINGS)).click();
        $(GROUP_SETTINGS).shouldBe(enabled.because(GROUP_SETTINGS_FOR_OPEN_SETTINGS)).click();
    }

    private void closeSettings() {
        $(CANCEL_CHANGE).shouldBe(enabled.because(CANCEL_CHANGE_FOR_CLOSE_SETTINGS)).click();
    }

    public GroupPage renameGroup(String newName) {
        this.openSettings();
        $(INPUT_NAME).shouldBe(enabled.because(INPUT_NAME_FOR_RENAME_GROUP)).doubleClick().setValue(newName);
        $(SAVE_SETTINGS).shouldBe(enabled.because(SAVE_SETTINGS_FOR_RENAME_GROUP)).click();
        this.closeSettings();
        return this;
    }

    public String getGroupName() {
        return $(GROUP_NAME).shouldBe(visible.because(GROUP_NAME_FOR_GET_NAME)).getText();
    }
}
