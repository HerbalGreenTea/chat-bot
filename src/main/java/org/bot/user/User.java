package org.bot.user;

public class User {

    private final UserSession userSession = new UserSession();

    public UserSession getUserSession() {
        return userSession;
    }
}
