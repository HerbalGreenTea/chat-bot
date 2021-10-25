package org.bot.dictionaries;

import java.util.ArrayList;

public record LexicalPair(
        String wordInEnglish,
        String transcription,
        ArrayList<String> wordTranslation
) {
    public static LexicalPair create(String word, String wordTranslation) {
        var answers = new ArrayList<String>();
        answers.add(wordTranslation);
        return new LexicalPair(word, "", answers);
    }

    // todo: чувствительно к регистрам
    public Boolean isCorrect(String answer) {
        return wordTranslation.contains(answer);
    }
}
