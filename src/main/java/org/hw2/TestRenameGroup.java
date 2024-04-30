package org.hw2;

import org.hw2.Core.Pages.GroupPage;
import org.hw2.Core.Pages.MainPage;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

public class TestRenameGroup extends BeforeTestLogin {
    MainPage mainPage;
    GroupPage groupPage;
    String oldName;

    @BeforeEach
    public void createGroupPage() {
        mainPage = new MainPage();
        groupPage = mainPage.openTestGroup();
        oldName = groupPage.getGroupName();
    }

    @Test
    @DisplayName("Test rename existing group")
    @Tag("group")
    public void testSuccessRenameGroup() {
        String newName = "NewName";
        if (oldName.equals(newName)) {
            newName = "SuperNewName";
        }

        String actualResult = groupPage.renameGroup(newName).getGroupName();
        String errorMessage = "Rename group failed";
        Assertions.assertEquals(newName, actualResult, errorMessage);
    }

    @AfterEach
    public void SendOldName() {
        groupPage.renameGroup(oldName);
    }
}
