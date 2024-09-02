package com.example.text_analyzer;

import com.example.text_analyzer.service.ConsonantAnalyzer;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.Map;

public class ConsonantAnalyzerTest {

    @Test
    public void testConsonantAnalyzerWithConsonantsOnly() {
        ConsonantAnalyzer analyzer = new ConsonantAnalyzer();
        Map<Character, Integer> result = analyzer.analyze("BCDFGbcdfg");

        assertEquals(2, result.get('B'));
        assertEquals(2, result.get('C'));
        assertEquals(2, result.get('D'));
        assertEquals(2, result.get('F'));
        assertEquals(2, result.get('G'));
    }

    @Test
    public void testConsonantAnalyzerWithNoConsonants() {
        ConsonantAnalyzer analyzer = new ConsonantAnalyzer();
        Map<Character, Integer> result = analyzer.analyze("AEIOU");

        assertTrue(result.isEmpty());
    }

    @Test
    public void testConsonantAnalyzerWithMixedCharacters() {
        ConsonantAnalyzer analyzer = new ConsonantAnalyzer();
        Map<Character, Integer> result = analyzer.analyze("Hello World");

        assertEquals(1, result.get('H'));
        assertEquals(3, result.get('L'));
        assertEquals(1, result.get('W'));
        assertEquals(1, result.get('R'));
        assertEquals(1, result.get('D'));
    }
}
