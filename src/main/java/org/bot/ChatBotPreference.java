package org.bot;

import org.bot.services.TypeService;

public class ChatBotPreference {

    private TypeService selectedTypeService;

    public TypeService getSelectedTypeService() {
        if (selectedTypeService == null) {
            return TypeService.EMPTY_SERVICE;
        }

        return selectedTypeService;
    }

    public void selectTypeService(TypeService typeService) {
        selectedTypeService = typeService;
    }
}
