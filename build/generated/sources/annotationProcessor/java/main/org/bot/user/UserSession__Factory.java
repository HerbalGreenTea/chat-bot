package org.bot.user;

import java.lang.Override;
import toothpick.Factory;
import toothpick.MemberInjector;
import toothpick.Scope;

public final class UserSession__Factory implements Factory<UserSession> {
  private MemberInjector<UserSession> memberInjector = new org.bot.user.UserSession__MemberInjector();

  @Override
  public UserSession createInstance(Scope scope) {
    scope = getTargetScope(scope);
    UserSession userSession = new UserSession();
    memberInjector.inject(userSession, scope);
    return userSession;
  }

  @Override
  public Scope getTargetScope(Scope scope) {
    return scope;
  }

  @Override
  public boolean hasScopeAnnotation() {
    return false;
  }

  @Override
  public boolean hasSingletonAnnotation() {
    return false;
  }

  @Override
  public boolean hasReleasableAnnotation() {
    return false;
  }

  @Override
  public boolean hasProvidesSingletonAnnotation() {
    return false;
  }

  @Override
  public boolean hasProvidesReleasableAnnotation() {
    return false;
  }
}
