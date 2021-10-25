package org.bot.statistics;

import org.bot.dictionaries.ILexicalDictionary;

public record TranslatedWordsStatistics(
        ILexicalDictionary lexicalDictionary
) implements IStatistics {

    @Override
    public String getStatistics() {
        var correctlyWords = lexicalDictionary.getCorrectlyTranslatedWords();
        var incorrectlyWords = lexicalDictionary.getIncorrectlyTranslatedWords();

        return String.format(
                "верно переведно %d слов\nне верно переведено %d слов",
                correctlyWords.size(),
                incorrectlyWords.size()
        );
    }
}
