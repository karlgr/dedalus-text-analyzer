package com.example.text_analyzer;

import com.example.text_analyzer.service.VowelAnalyzer;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.Map;


public class VowelAnalyzerTest {

    @Test
    public void testVowelAnalyzerWithVowelsOnly() {
        VowelAnalyzer analyzer = new VowelAnalyzer();
        Map<Character, Integer> result = analyzer.analyze("AEIOUaeiou");

        assertEquals(2, result.get('A'));
        assertEquals(2, result.get('E'));
        assertEquals(2, result.get('I'));
        assertEquals(2, result.get('O'));
        assertEquals(2, result.get('U'));
    }

    @Test
    public void testVowelAnalyzerWithNoVowels() {
        VowelAnalyzer analyzer = new VowelAnalyzer();
        Map<Character, Integer> result = analyzer.analyze("BCDFG");

        assertTrue(result.isEmpty());
    }

    @Test
    public void testVowelAnalyzerWithMixedCharacters() {
        VowelAnalyzer analyzer = new VowelAnalyzer();
        Map<Character, Integer> result = analyzer.analyze("Hello World");

        assertEquals(1, result.get('E'));
        assertEquals(2, result.get('O'));
        assertNull(result.get('A'));
    }

}
