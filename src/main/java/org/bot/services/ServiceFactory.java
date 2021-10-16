package org.bot.services;

public class ServiceFactory {

    public IServiceBot createService(TypeService typeService) {
        if (typeService == TypeService.TRANSLATION_SERVICE) {
            return new TranslationService();
        } else {
            return new EmptyService();
        }
    }
}
