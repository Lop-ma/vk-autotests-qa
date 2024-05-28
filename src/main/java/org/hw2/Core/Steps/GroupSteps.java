package org.hw2.Core.Steps;

import org.hw2.Core.Pages.GroupPage;

public class GroupSteps extends LoginSteps {
    public String loginBotGoToTestGroupReturnOldName() {
        return this
                .loginBot()
                .goToTestGroup()
                .getGroupName();
    }

    public void renameGroup(String name) {
        new GroupPage()
                .renameGroup(name);
    }
}
