package org.bot;

import java.util.ArrayList;

public class LexicalPair {

    private final String wordInEnglish;
    private String transcription = "";
    private final ArrayList<String> wordTranslation;

    public static LexicalPair create(String word, String wordTranslation) {
        var answers = new ArrayList<String>();
        answers.add(wordTranslation);
        return new LexicalPair(word, "", answers);
    }

    public LexicalPair(String wordInEnglish, String transcription, ArrayList<String> wordTranslation) {
        this.wordInEnglish = wordInEnglish;
        this.transcription = transcription;
        this.wordTranslation = new ArrayList<>(wordTranslation);
    }

    public LexicalPair(String wordInEnglish, ArrayList<String> wordTranslation) {
        this.wordInEnglish = wordInEnglish;
        this.wordTranslation = new ArrayList<>(wordTranslation);
    }

    public String getWordInEnglish() {
        return wordInEnglish;
    }

    public String getTranscription() { return transcription; }

    public ArrayList<String> getWordTranslation() {
        return wordTranslation;
    }

    // todo: чувствительно к регистрам
    public Boolean isCorrect(String answer) {
        return wordTranslation.contains(answer);
    }
}
