package org.bot.services;

import java.lang.Override;
import toothpick.Factory;
import toothpick.MemberInjector;
import toothpick.Scope;

public final class ServiceFactory__Factory implements Factory<ServiceFactory> {
  private MemberInjector<ServiceFactory> memberInjector = new org.bot.services.ServiceFactory__MemberInjector();

  @Override
  public ServiceFactory createInstance(Scope scope) {
    scope = getTargetScope(scope);
    ServiceFactory serviceFactory = new ServiceFactory();
    memberInjector.inject(serviceFactory, scope);
    return serviceFactory;
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
