package org.bot.services;

import org.bot.dictionaries.ILexicalDictionary;
import org.bot.dictionaries.LexicalPair;

import java.util.List;

public class TranslationService implements IServiceBot {

    // TODO словарь вынести в отдельный класс по работе с лексическими парами
    private final ILexicalDictionary dictionary;
    private final List<LexicalPair> words;
    private int numberLexicalPair = 0;

    public TranslationService(ILexicalDictionary dictionary) {
        this.dictionary = dictionary;
        this.words = dictionary.getAllWords();
    }

    @Override
    public TypeService getServiceType() {
        return TypeService.TRANSLATION_SERVICE;
    }

    @Override
    public String getMessageForUser() {
        return "попробуй перевести слово - " + words.get(numberLexicalPair).getWordInEnglish();
    }

    @Override
    public String processUserMessage(String message) {
        var lexicalPair = getNextPair();

        dictionary.addTranslatedWord(lexicalPair.isCorrect(message), lexicalPair);

        if (lexicalPair.isCorrect(message)) {
            return "все верно!";
        } else {
            return "попробуй другое слово";
        }
    }

    private LexicalPair getNextPair() {
        // TODO тож чото так себе тема
        var currentLexicalPair = words.get(numberLexicalPair);

        if (numberLexicalPair < (words.size() - 1)) {
            numberLexicalPair += 1;
        } else {
            numberLexicalPair = 0;
        }

        return currentLexicalPair;
    }
}
