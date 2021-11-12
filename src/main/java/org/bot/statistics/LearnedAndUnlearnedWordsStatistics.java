package org.bot.statistics;

import org.bot.dictionaries.ILexicalDictionary;

public class LearnedAndUnlearnedWordsStatistics implements IStatistics {

    private final ILexicalDictionary lexicalDictionary;
    private int percentageWordsLearned;

    public LearnedAndUnlearnedWordsStatistics(ILexicalDictionary lexicalDictionary) {
        this.lexicalDictionary = lexicalDictionary;
    }

    @Override
    public void createStatistics() {
        var allWords = lexicalDictionary.getAllWords();
        var learnedWords = lexicalDictionary.getLearnedWords();

        percentageWordsLearned = (int) ((double) learnedWords.size() / (double) allWords.size() * 100);
    }

    @Override
    public String getTextFormatStatistics() {
        createStatistics();
        return String.format(
                "изучено %d%% слов\nне изучено %d%% слов",
                percentageWordsLearned,
                100 - percentageWordsLearned
        );
    }
}
