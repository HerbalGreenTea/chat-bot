package org.bot.commands;

import java.lang.Override;
import toothpick.Factory;
import toothpick.MemberInjector;
import toothpick.Scope;

public final class SelectTranslationServiceBotCommand__Factory implements Factory<SelectTranslationServiceBotCommand> {
  private MemberInjector<SelectTranslationServiceBotCommand> memberInjector = new org.bot.commands.SelectTranslationServiceBotCommand__MemberInjector();

  @Override
  public SelectTranslationServiceBotCommand createInstance(Scope scope) {
    scope = getTargetScope(scope);
    SelectTranslationServiceBotCommand selectTranslationServiceBotCommand = new SelectTranslationServiceBotCommand();
    memberInjector.inject(selectTranslationServiceBotCommand, scope);
    return selectTranslationServiceBotCommand;
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
