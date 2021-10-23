package org.bot.services;

import org.bot.user.UserPreference;

public record ServiceFactory(UserPreference userPreference) {

    public IServiceBot createService(TypeService typeService) {
        if (typeService == TypeService.TRANSLATION_SERVICE) {
            return new TranslationService(userPreference.getLexicalDictionary());
        } else {
            return new EmptyService();
        }
    }
}
