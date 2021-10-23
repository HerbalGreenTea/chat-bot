package org.bot.dictionaries;

import java.util.ArrayList;
import java.util.List;

public class EnglishRussianDictionary implements ILexicalDictionary {

    //    private final Map<Integer, LexicalPair> correctlyTranslatedWords = Collections.emptyMap();
//    private final Map<Integer, LexicalPair> incorrectlyTranslatedWords = Collections.emptyMap();
    private List<LexicalPair> correctlyTranslatedWords = new ArrayList<>();
    private List<LexicalPair> incorrectlyTranslatedWords = new ArrayList<>();

    private final List<LexicalPair> words = new ArrayList();

    {
        words.add(LexicalPair.create("cat", "кошка"));
        words.add(LexicalPair.create("dog", "собака"));
        words.add(LexicalPair.create("home", "дом"));
        words.add(LexicalPair.create("page", "страница"));
        words.add(LexicalPair.create("ring", "кольцо"));
        words.add(LexicalPair.create("fire", "огонь"));
        words.add(LexicalPair.create("or", "или"));
        words.add(LexicalPair.create("and", "и"));
        words.add(LexicalPair.create("river", "река"));
        words.add(LexicalPair.create("city", "город"));
        words.add(LexicalPair.create("water", "вода"));
    }

    @Override
    public List<LexicalPair> getAllWords() {
        return words;
    }

    @Override
    public void addTranslatedWord(Boolean isCorrectTranslate, LexicalPair lexicalPair) {
        if (isCorrectTranslate)
            correctlyTranslatedWords.add(lexicalPair);
        else
            incorrectlyTranslatedWords.add(lexicalPair);
    }

    @Override
    public void addLearnedOrUnlearnedWord(Boolean isLearned, LexicalPair lexicalPair) {

    }

    @Override
    public List<LexicalPair> getCorrectlyTranslatedWords() {
        return correctlyTranslatedWords;
    }

    @Override
    public List<LexicalPair> getIncorrectlyTranslatedWords() {
        return incorrectlyTranslatedWords;
    }

    @Override
    public List<LexicalPair> getLearnedWords() {
        return null;
    }

    @Override
    public List<LexicalPair> getUnlearnedWords() {
        return null;
    }
}
