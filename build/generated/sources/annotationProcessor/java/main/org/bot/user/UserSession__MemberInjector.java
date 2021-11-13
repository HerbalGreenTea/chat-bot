package org.bot.user;

import java.lang.Override;
import org.bot.GlobalFileLogger;
import toothpick.MemberInjector;
import toothpick.Scope;

public final class UserSession__MemberInjector implements MemberInjector<UserSession> {
  @Override
  public void inject(UserSession target, Scope scope) {
    target.userPreference = scope.getInstance(UserPreference.class);
    target.globalFileLogger = scope.getInstance(GlobalFileLogger.class);
  }
}
