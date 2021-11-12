package org.bot.dictionaries;

import java.util.List;
import java.util.Set;

public interface ILexicalDictionary {
    List<LexicalPair> getAllWords();

    Set<LexicalPair> getCorrectlyTranslatedWords();

    Set<LexicalPair> getIncorrectlyTranslatedWords();

    void addTranslatedWord(Boolean isCorrectTranslate, LexicalPair lexicalPair);

    Set<LexicalPair> getLearnedWords();

    Set<LexicalPair> getUnlearnedWords();

    void updateStatusWord(LexicalPair lexicalPair);
}
