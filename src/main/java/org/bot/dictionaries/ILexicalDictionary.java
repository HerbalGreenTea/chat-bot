package org.bot.dictionaries;

import java.util.List;

public interface ILexicalDictionary {
    List<LexicalPair> getAllWords();

    List<LexicalPair> getCorrectlyTranslatedWords();

    List<LexicalPair> getIncorrectlyTranslatedWords();

    void addTranslatedWord(Boolean isCorrectTranslate, LexicalPair lexicalPair);

    List<LexicalPair> getLearnedWords();

    List<LexicalPair> getUnlearnedWords();

    void addLearnedOrUnlearnedWord(Boolean isLearned, LexicalPair lexicalPair);
}
