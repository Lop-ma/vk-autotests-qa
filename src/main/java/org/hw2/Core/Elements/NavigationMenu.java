package org.hw2.Core.Elements;

import org.openqa.selenium.By;
import org.hw2.Core.Loadable.LoadableElement;
import org.hw2.Core.Pages.GroupPage;
import org.hw2.Core.Pages.UserPage;

import static com.codeborne.selenide.Condition.enabled;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class NavigationMenu extends LoadableElement {
    private static final By NAVIGATION_MENU = By.xpath(".//*[@role='navigation']/div");
    private static final By PUBLISH_BUTTON = By.xpath(".//button[@data-l='t,pf_dropdown']");
    private static final By PUBLISH_NOTE = By.xpath(".//span[@data-l='t,feed.posting.ui.input']");
    private static final By INPUT_FOR_NOTE = By.xpath(".//div[contains(@class, 'ok-posting-handler')]");
    private static final By POSTING_BUTTON = By.xpath(".//button[@data-l='t,button.submit']");
    private static final By PUBLICATION_MESSAGE = By.xpath(".//div[@class='tip-block_cnt']");
    private static final By TO_USER_PAGE = By.xpath(".//*[@data-l='t,userPage']");
    private static final By TO_GROUPS_PAGE = By.xpath(".//*[@data-l='t,userAltGroup']");
    private static final By SHOW_ALL = By.xpath(".//a[text()='Показать все']");
    private static final By TEST_GROUP = By.xpath(".//a[contains(@class, 'card_name') and contains(@href, '70000005781564')]");


    private static final String MENU_BLOCK_ON_NAVIGATION_MENU = "Block with menu should be enabled on navigation menu";
    private static final String BUTTON_TO_USER_PAGE_ON_NAVIGATION_MENU = "Button for go to User Page should be enabled on navigation menu";
    private static final String PUBLISH_BUTTON_FOR_POST_NOTE = "Publish button should be enabled for post note";
    private static final String PUBLISH_NOTE_BUTTON_FOR_POST_NOTE = "Publish note button should be enabled for post note";
    private static final String NAVIGATION_MENU_FOR_GO_TO_USER_PAGE = "Navigation menu should be enabled for go to User page";
    private static final String BUTTON_TO_USER_PAGE_FOR_GO_TO_USER_PAGE = "Button redirect to User page should be enabled for go to User page";
    private static final String NAVIGATION_MENU_FOR_GO_TO_GROUPS_PAGE = "Navigation menu should be enabled for go to Groups page";
    private static final String BUTTON_TO_GROUPS_PAGE_FOR_GO_TO_GROUPS_PAGE = "Button redirect to Groups page should be enabled for go to Groups page";
    private static final String INPUT_FOR_POST_NOTE = "Note input field should be enabled in posting field for post note";
    private static final String INPUT_FOR_NOTE_FOR_SET_VALUE = "Note input field should be enabled in posting field for enter note text";
    private static final String POSTING_BUTTON_FOR_POST_NOTE = "Posting button should be enabled for post note";
    private static final String PUBLICATION_MESSAGE_FOR_GET_TEXT = "Publication message should be enabled for get text";
    private static final String SHOW_ALL_OPEN_TEST_GROUP = "Button Show all should be enabled for open group page";
    private static final String NAME_TEST_GROUP_OPEN_TEST_GROUP = "Name test group should be enabled for open group page";


    public NavigationMenu() {
        this.checkElement();
    }

    @Override
    public NavigationMenu checkElement() {
        $(NAVIGATION_MENU)
                .shouldBe(enabled.because(MENU_BLOCK_ON_NAVIGATION_MENU))
                .$(TO_USER_PAGE)
                .shouldBe(enabled.because(BUTTON_TO_USER_PAGE_ON_NAVIGATION_MENU));
        return this;
    }

    public String postNote() {
        String textInPost = "Some text";
        $(PUBLISH_BUTTON)
                .shouldBe(enabled.because(PUBLISH_BUTTON_FOR_POST_NOTE))
                .click();
        $(PUBLISH_NOTE)
                .shouldBe(enabled.because(PUBLISH_NOTE_BUTTON_FOR_POST_NOTE))
                .click();
        $(INPUT_FOR_NOTE)
                .shouldBe(enabled.because(INPUT_FOR_POST_NOTE))
                .click();
        $(INPUT_FOR_NOTE)
                .shouldBe(enabled.because(INPUT_FOR_NOTE_FOR_SET_VALUE))
                .setValue(textInPost);
        $(POSTING_BUTTON)
                .shouldBe(enabled.because(POSTING_BUTTON_FOR_POST_NOTE))
                .click();
        return $(PUBLICATION_MESSAGE)
                .shouldBe(visible.because(PUBLICATION_MESSAGE_FOR_GET_TEXT))
                .getText();

    }

    public UserPage goToUserPage() {
        $(NAVIGATION_MENU)
                .shouldBe(enabled.because(NAVIGATION_MENU_FOR_GO_TO_USER_PAGE))
                .$(TO_USER_PAGE)
                .shouldBe(enabled.because(BUTTON_TO_USER_PAGE_FOR_GO_TO_USER_PAGE))
                .click();
        return new UserPage();
    }

    public GroupPage goToTestGroup() {
        $(NAVIGATION_MENU)
                .shouldBe(enabled.because(NAVIGATION_MENU_FOR_GO_TO_GROUPS_PAGE))
                .$(TO_GROUPS_PAGE)
                .shouldBe(enabled.because(BUTTON_TO_GROUPS_PAGE_FOR_GO_TO_GROUPS_PAGE))
                .click();
        $(SHOW_ALL)
                .shouldBe(enabled.because(SHOW_ALL_OPEN_TEST_GROUP))
                .click();
        $(TEST_GROUP)
                .shouldBe(enabled.because(NAME_TEST_GROUP_OPEN_TEST_GROUP))
                .click();
        return new GroupPage();
    }
}
