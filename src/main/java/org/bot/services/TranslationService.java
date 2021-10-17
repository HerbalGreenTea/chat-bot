package org.bot.services;

import org.bot.LexicalPair;

import java.util.ArrayList;

public class TranslationService implements IServiceBot {

    // TODO словарь вынести в отдельный класс по работе с лексическими парами
    private final ArrayList<LexicalPair> dictionary;
    private int numberLexicalPair = 0;

    public TranslationService() {
        dictionary = new ArrayList<>();
        dictionary.add(LexicalPair.create("cat", "кошка"));
        dictionary.add(LexicalPair.create("dog", "собака"));
        dictionary.add(LexicalPair.create("home", "дом"));
    }

    @Override
    public TypeService getServiceType() {
        return TypeService.TRANSLATION_SERVICE;
    }

    @Override
    public String getMessageForUser() {
        return "попробуй перевести слово - " + dictionary.get(numberLexicalPair).getWordInEnglish();
    }

    @Override
    public String processUserMessage(String message) {
        var lexicalPair = getNexPair();

        if (lexicalPair.isCorrect(message)) {
            return  "все верно!";
        } else {
            return  "попробуй другое слово";
        }
    }

    private LexicalPair getNexPair() {
        // TODO тож чото так себе тема
        var currentLexicalPair = dictionary.get(numberLexicalPair);

        if (numberLexicalPair < (dictionary.size() - 1)) {
            numberLexicalPair += 1;
        } else {
            numberLexicalPair = 0;
        }

        return currentLexicalPair;
    }
}
