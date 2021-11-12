package org.bot.commands;

import java.lang.Override;
import toothpick.Factory;
import toothpick.MemberInjector;
import toothpick.Scope;

public final class GetStatisticsBotCommand__Factory implements Factory<GetStatisticsBotCommand> {
  private MemberInjector<GetStatisticsBotCommand> memberInjector = new org.bot.commands.GetStatisticsBotCommand__MemberInjector();

  @Override
  public GetStatisticsBotCommand createInstance(Scope scope) {
    scope = getTargetScope(scope);
    GetStatisticsBotCommand getStatisticsBotCommand = new GetStatisticsBotCommand();
    memberInjector.inject(getStatisticsBotCommand, scope);
    return getStatisticsBotCommand;
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
