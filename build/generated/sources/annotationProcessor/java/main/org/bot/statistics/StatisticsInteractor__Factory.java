package org.bot.statistics;

import java.lang.Override;
import toothpick.Factory;
import toothpick.MemberInjector;
import toothpick.Scope;

public final class StatisticsInteractor__Factory implements Factory<StatisticsInteractor> {
  private MemberInjector<StatisticsInteractor> memberInjector = new org.bot.statistics.StatisticsInteractor__MemberInjector();

  @Override
  public StatisticsInteractor createInstance(Scope scope) {
    scope = getTargetScope(scope);
    StatisticsInteractor statisticsInteractor = new StatisticsInteractor();
    memberInjector.inject(statisticsInteractor, scope);
    return statisticsInteractor;
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
