package org.bot.commands;

import java.lang.Override;
import org.bot.user.UserPreference;
import toothpick.MemberInjector;
import toothpick.Scope;

public final class SelectTranslationServiceBotCommand__MemberInjector implements MemberInjector<SelectTranslationServiceBotCommand> {
  @Override
  public void inject(SelectTranslationServiceBotCommand target, Scope scope) {
    target.userPreference = scope.getInstance(UserPreference.class);
  }
}
