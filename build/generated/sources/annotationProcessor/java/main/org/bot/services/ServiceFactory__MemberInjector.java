package org.bot.services;

import java.lang.Override;
import org.bot.user.UserPreference;
import toothpick.MemberInjector;
import toothpick.Scope;

public final class ServiceFactory__MemberInjector implements MemberInjector<ServiceFactory> {
  @Override
  public void inject(ServiceFactory target, Scope scope) {
    target.userPreference = scope.getInstance(UserPreference.class);
  }
}
