package com.example.text_analyzer.service;

public class TextAnalyzerFactory {

    private static final String VOWELS_TYPE = "vowels";
    private static final String CONSONANTS_TYPE = "consonants";

    public static TextAnalyzerStrategy getAnalyzer(String type) {
        if (VOWELS_TYPE.equalsIgnoreCase(type)) {
            return new VowelAnalyzer();
        } else if (CONSONANTS_TYPE.equalsIgnoreCase(type)) {
            return new ConsonantAnalyzer();
        } else {
            throw new IllegalArgumentException("Invalid analysis type: " + type);
        }
    }

}
