package org.bot.services;

import org.bot.Main;
import org.bot.user.UserPreference;
import toothpick.Scope;
import toothpick.Toothpick;

import javax.inject.Inject;

public class ServiceFactory {

    @Inject
    UserPreference userPreference;

    public ServiceFactory() {
        Scope global = Toothpick.openScope(Main.NAME_GLOBAL_SCOPE);
        Toothpick.inject(this, global);
    }

    public IServiceBot createService() {
        if (userPreference.getSelectedTypeService() == TypeService.TRANSLATION_SERVICE) {
            return new TranslationService(userPreference.getLexicalDictionary());
        } else {
            return new EmptyService();
        }
    }
}
