package org.bot.dictionaries;

import java.util.List;

public interface ILexicalDictionary {
    List<LexicalPair> getAllWords();

    List<LexicalPair> getCorrectlyTranslatedWords();

    List<LexicalPair> getIncorrectlyTranslatedWords();

    List<LexicalPair> getLearnedWords();

    List<LexicalPair> getUnlearnedWords();
}
