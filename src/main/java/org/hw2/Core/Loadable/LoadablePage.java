package org.hw2.Core.Loadable;

import org.hw2.Core.Elements.NavigationMenu;
import org.hw2.Core.Pages.GroupPage;
import org.hw2.Core.Pages.UserPage;

public abstract class LoadablePage {
    public abstract LoadablePage checkPage();

    public UserPage goToUserPage() {
        return new NavigationMenu()
                .goToUserPage();
    }

    public GroupPage goToTestGroup() {
        return new NavigationMenu()
                .goToTestGroup();
    }

    public String postNoteAndReturnMessage() {
        return new NavigationMenu()
                .postNote();
    }
}
