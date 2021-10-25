package org.bot.dictionaries;

import java.util.*;

public class EnglishRussianDictionary implements ILexicalDictionary {

    private static Integer COUNT_REPEAT_FOR_LEARN = 3;

    private final Map<LexicalPair, Integer> correctlyTranslatedWords = new HashMap<>();
    private final Map<LexicalPair, Integer> incorrectlyTranslatedWords = new HashMap<>();
    private final Set<LexicalPair> learnedWords = new HashSet<>();
    private final Set<LexicalPair> unlearnedWords = new HashSet<>();

    private final List<LexicalPair> words = new ArrayList<>();
    {
        words.add(LexicalPair.create("cat", "кошка"));
        words.add(LexicalPair.create("dog", "собака"));
        words.add(LexicalPair.create("home", "дом"));
//        words.add(LexicalPair.create("page", "страница"));
//        words.add(LexicalPair.create("ring", "кольцо"));
//        words.add(LexicalPair.create("fire", "огонь"));
//        words.add(LexicalPair.create("or", "или"));
//        words.add(LexicalPair.create("and", "и"));
//        words.add(LexicalPair.create("river", "река"));
//        words.add(LexicalPair.create("city", "город"));
//        words.add(LexicalPair.create("water", "вода"));
    }

    @Override
    public List<LexicalPair> getAllWords() {
        return words;
    }

    @Override
    public void addTranslatedWord(Boolean isCorrectTranslate, LexicalPair lexicalPair) {
        if (isCorrectTranslate) {
            correctlyTranslatedWords.merge(lexicalPair, 1, Integer::sum);
            addLearnedOrUnlearnedWord(lexicalPair);
        } else {
            incorrectlyTranslatedWords.merge(lexicalPair, 1, Integer::sum);
        }
    }

    @Override
    public void addLearnedOrUnlearnedWord(LexicalPair lexicalPair) {
        if (correctlyTranslatedWords.get(lexicalPair) == COUNT_REPEAT_FOR_LEARN) {
            learnedWords.add(lexicalPair);
            unlearnedWords.remove(lexicalPair);
        } else if (correctlyTranslatedWords.get(lexicalPair) < COUNT_REPEAT_FOR_LEARN) {
            unlearnedWords.add(lexicalPair);
        }
    }

    @Override
    public Set<LexicalPair> getCorrectlyTranslatedWords() {
        return correctlyTranslatedWords.keySet();
    }

    @Override
    public Set<LexicalPair> getIncorrectlyTranslatedWords() {
        return incorrectlyTranslatedWords.keySet();
    }

    @Override
    public Set<LexicalPair> getLearnedWords() {
        return learnedWords;
    }

    @Override
    public Set<LexicalPair> getUnlearnedWords() {
        return unlearnedWords;
    }
}
