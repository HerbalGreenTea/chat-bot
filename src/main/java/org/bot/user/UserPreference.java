package org.bot.user;

import org.bot.dictionaries.EnglishRussianDictionary;
import org.bot.dictionaries.ILexicalDictionary;
import org.bot.services.TypeService;

import javax.inject.Inject;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Objects;

public class UserPreference {

    private TypeService selectedTypeService;
    private final ILexicalDictionary lexicalDictionary = new EnglishRussianDictionary();
    private final Calendar timeStartSession = new GregorianCalendar();

    @Inject
    public UserPreference() {
    }

    public TypeService getSelectedTypeService() {
        return Objects.requireNonNullElse(selectedTypeService, TypeService.EMPTY_SERVICE);
    }

    public void selectTypeService(TypeService typeService) {
        selectedTypeService = typeService;
    }

    public ILexicalDictionary getLexicalDictionary() {
        return lexicalDictionary;
    }

    public Calendar getTimeStartSession() {
        return timeStartSession;
    }
}
