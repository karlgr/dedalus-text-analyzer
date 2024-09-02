package com.example.text_analyzer.service;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class VowelAnalyzer implements TextAnalyzerStrategy{

    private static final Set<Character> VOWELS = Set.of('A', 'E', 'I', 'O', 'U');

    @Override
    public Map<Character, Integer> analyze(String text) {
        Map<Character, Integer> vowelCounts = new HashMap<>();
        for (char c : text.toUpperCase().toCharArray()) {
            if (VOWELS.contains(c)) {
                vowelCounts.merge(c, 1, Integer::sum);
            }
        }
        return vowelCounts;
    }
}
