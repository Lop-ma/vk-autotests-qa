package org.hw2;

import org.hw2.Pages.GroupPage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TestRenameGroup extends BaseTest {
    GroupPage groupPage;

    @BeforeEach
    public void createPage() {
        groupPage = new GroupPage();
        groupPage.openGroup();
    }

    @Test
    public void renameGroup() {
        String oldName = groupPage.getName();
        String newName = "NewName";
        if (oldName.equals(newName)) {
            newName = "SuperNewName";
        }

        groupPage.rename(newName)
                .shouldHaveName(newName);

        groupPage.rename(oldName);
    }
}
