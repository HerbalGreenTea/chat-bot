package org.bot.dictionaries;

import java.util.ArrayList;
import java.util.Locale;

public record LexicalPair(
        String word,
        String transcription,
        ArrayList<String> wordTranslation
) {
    public static LexicalPair create(String word, String wordTranslation) {
        var answers = new ArrayList<String>();
        answers.add(wordTranslation);
        return new LexicalPair(word, "", answers);
    }

    public Boolean isCorrect(String answer) {
        return wordTranslation.contains(answer.toLowerCase(Locale.ROOT));
    }
}
