package com.example.text_analyzer.service;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class ConsonantAnalyzer implements TextAnalyzerStrategy{

    private static final Set<Character> VOWELS = Set.of('A', 'E', 'I', 'O', 'U');

    @Override
    public Map<Character, Integer> analyze(String text) {
        Map <Character, Integer> consonantCounts = new HashMap<>();
        for (char c : text.toUpperCase().toCharArray()) {
            if (isConsonant(c)) {
                consonantCounts.merge(c, 1, Integer::sum);
            }
        }
        return consonantCounts;
    }

    private boolean isConsonant(char c) {
        return Character.isLetter(c) && !VOWELS.contains(Character.toUpperCase(c));
    }
}
