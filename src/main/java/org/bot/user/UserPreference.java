package org.bot.user;

import org.bot.services.TypeService;

import java.util.Objects;

public class UserPreference {

    private TypeService selectedTypeService;

    public TypeService getSelectedTypeService() {
        return Objects.requireNonNullElse(selectedTypeService, TypeService.EMPTY_SERVICE);
    }

    public void selectTypeService(TypeService typeService) {
        selectedTypeService = typeService;
    }
}
