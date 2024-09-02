package com.example.text_analyzer.service;

import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * The program for calculating how many times letter in given sentence appears.
 * It gives numbers either for vowels or for consonants based on program input.
 * <p>
 * The first parameter can be 'vowels' or 'consonants'
 * The second parameter is the sentence to be analyzed.
 * <p>
 * Task: Refactor this code to be production ready and create appropriate unit tests.
 */
@Service
public class TextAnalyzerService {

  public Map<Character, Integer> analyzeText(String type, String text) {
    TextAnalyzerStrategy analyzer = TextAnalyzerFactory.getAnalyzer(type);
    return analyzer.analyze(text);
  }

  /*
  public static void main(String[] args) {
    if (args.length < 2) {
      System.out.println("You need to provide two arguments. Usage: java TextAnalyzer <vowels|consonants> <text>");
      return;
    }

    try {
      TextAnalyzerStrategy analyzer = TextAnalyzerFactory.getAnalyzer(args[0]);
      String input = args[1];
      Map<Character, Integer> result = analyzer.analyze(input);
      result.forEach((key, value) -> System.out.println(key + ": " + value));
    } catch (IllegalArgumentException e) {
      System.out.println("Invalid argument. Usage: java TextAnalyzer <vowels|consonants> <text>");
    }
  }
  */
}
