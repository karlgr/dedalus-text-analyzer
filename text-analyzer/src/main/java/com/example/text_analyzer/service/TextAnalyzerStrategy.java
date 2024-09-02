package com.example.text_analyzer.service;

import java.util.Map;

public interface TextAnalyzerStrategy {
    Map<Character, Integer> analyze(String text);
}
