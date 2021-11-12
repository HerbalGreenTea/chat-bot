package org.bot.user;

import java.lang.Override;
import toothpick.Factory;
import toothpick.Scope;

public final class UserPreference__Factory implements Factory<UserPreference> {
  @Override
  public UserPreference createInstance(Scope scope) {
    UserPreference userPreference = new UserPreference();
    return userPreference;
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
