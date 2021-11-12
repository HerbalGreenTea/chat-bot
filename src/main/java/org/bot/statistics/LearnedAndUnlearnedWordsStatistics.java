package org.bot.statistics;

import org.bot.dictionaries.ILexicalDictionary;

public record LearnedAndUnlearnedWordsStatistics(
        ILexicalDictionary lexicalDictionary
) implements IStatistics {
    @Override
    public String getStatistics() {
        var allWords = lexicalDictionary.getAllWords();
        var learnedWords = lexicalDictionary.getLearnedWords();

        var percentageWordsLearned = (int) ((double) learnedWords.size() / (double) allWords.size() * 100);

        return String.format(
                "изучено %d%% слов\nне изучено %d%% слов",
                percentageWordsLearned,
                100 - percentageWordsLearned
        );
    }
}
