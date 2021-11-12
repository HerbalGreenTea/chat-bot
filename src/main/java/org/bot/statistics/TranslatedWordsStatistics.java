package org.bot.statistics;

import org.bot.dictionaries.ILexicalDictionary;
import org.bot.dictionaries.LexicalPair;

import java.util.Set;

public class TranslatedWordsStatistics implements IStatistics {

    private final ILexicalDictionary lexicalDictionary;
    private Set<LexicalPair> correctlyWords;
    private Set<LexicalPair> incorrectlyWords;

    public TranslatedWordsStatistics(ILexicalDictionary lexicalDictionary) {
        this.lexicalDictionary = lexicalDictionary;
    }

    @Override
    public void createStatistics() {
        correctlyWords = lexicalDictionary.getCorrectlyTranslatedWords();
        incorrectlyWords = lexicalDictionary.getIncorrectlyTranslatedWords();
    }

    @Override
    public String getTextFormatStatistics() {
        createStatistics();
        return String.format(
                "верно переведно %d слов\nне верно переведено %d слов",
                correctlyWords.size(),
                incorrectlyWords.size()
        );
    }
}
