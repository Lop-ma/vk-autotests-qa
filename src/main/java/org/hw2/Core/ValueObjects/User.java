package org.hw2.Core.ValueObjects;

public class User {
    private static final String LOGIN = "technopol68";
    private static final String PASSWORD = "technopolisPassword";

    private final String login;
    private final String password;

    public User() {
        this.login = LOGIN;
        this.password = PASSWORD;
    }

    public User(String login, String password) {
        this.login = login;
        this.password = password;
    }

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }
}
