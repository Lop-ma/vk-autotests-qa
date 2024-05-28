package org.hw2.Core.Steps;

import org.hw2.Core.Pages.LoginPage;
import org.hw2.Core.Pages.MainPage;
import org.hw2.Core.ValueObjects.User;

public class LoginSteps {
    public MainPage loginBot() {
        return new LoginPage()
                .login(new User());
    }
}
