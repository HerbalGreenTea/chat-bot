package org.bot;

import org.bot.platforms.PlatformStart;
import org.bot.platforms.TypePlatform;
import org.bot.user.User;
import toothpick.Scope;
import toothpick.Toothpick;

public class Main {

    public static String NAME_GLOBAL_SCOPE = "GlobalScope";

    public static void main(String[] args) {
        Scope globalScope = Toothpick.openScope(NAME_GLOBAL_SCOPE);
        globalScope.installModules(new GlobalModule());

        var user = new User();
        PlatformStart.start(TypePlatform.TELEGRAM, user);
    }
}
