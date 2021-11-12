package org.bot.commands;

import java.lang.Override;
import org.bot.statistics.StatisticsInteractor;
import toothpick.MemberInjector;
import toothpick.Scope;

public final class GetStatisticsBotCommand__MemberInjector implements MemberInjector<GetStatisticsBotCommand> {
  @Override
  public void inject(GetStatisticsBotCommand target, Scope scope) {
    target.statisticsInteractor = scope.getInstance(StatisticsInteractor.class);
  }
}
