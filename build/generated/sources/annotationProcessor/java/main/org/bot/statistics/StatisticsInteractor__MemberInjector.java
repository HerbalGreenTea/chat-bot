package org.bot.statistics;

import java.lang.Override;
import org.bot.user.UserPreference;
import toothpick.MemberInjector;
import toothpick.Scope;

public final class StatisticsInteractor__MemberInjector implements MemberInjector<StatisticsInteractor> {
  @Override
  public void inject(StatisticsInteractor target, Scope scope) {
    target.userPreference = scope.getInstance(UserPreference.class);
  }
}
