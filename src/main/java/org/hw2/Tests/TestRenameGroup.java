package org.hw2.Tests;

import org.hw2.BaseTest;
import org.hw2.Core.Pages.GroupPage;
import org.hw2.Core.Steps.GroupSteps;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static org.hw2.Core.DataRegistry.RandomGroupName.generateRandomGroupName;

public class TestRenameGroup extends BaseTest {
    GroupSteps steps = new GroupSteps();
    GroupPage groupPage;
    String oldName;

    @BeforeEach
    public void createGroupPage() {
        oldName = steps
                .loginBotGoToTestGroupReturnOldName();
        groupPage = new GroupPage();
    }

    @Test
    @DisplayName("Test rename existing group")
    @Tag("group")
    public void testSuccessRenameGroup() {
        String newName = generateRandomGroupName();

        String actualResult = groupPage
                .renameGroup(newName)
                .getGroupName();
        String errorMessage = "Rename group failed";
        Assertions.assertEquals(newName, actualResult, errorMessage);
    }

    @AfterEach
    public void SendOldName() {
        steps
                .renameGroup(oldName);
    }
}
