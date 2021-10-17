package org.bot;

import org.bot.platforms.PlatformStart;
import org.bot.platforms.TypePlatform;
import org.bot.user.User;

public class Main {

    public static void main(String[] args) {
        var user = new User();
        PlatformStart.start(TypePlatform.TELEGRAM, user);
    }
}
