package com.example.text_analyzer;

import com.example.text_analyzer.service.ConsonantAnalyzer;
import com.example.text_analyzer.service.TextAnalyzerFactory;
import com.example.text_analyzer.service.TextAnalyzerStrategy;
import com.example.text_analyzer.service.VowelAnalyzer;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TextAnalyzerFactoryTest {

    @Test
    public void testFactoryReturnsVowelAnalyzer() {
        TextAnalyzerStrategy analyzer = TextAnalyzerFactory.getAnalyzer("vowels");
        assertInstanceOf(VowelAnalyzer.class, analyzer);
    }

    @Test
    public void testFactoryReturnsConsonantAnalyzer() {
        TextAnalyzerStrategy analyzer = TextAnalyzerFactory.getAnalyzer("consonants");
        assertInstanceOf(ConsonantAnalyzer.class, analyzer);
    }

    @Test
    public void testFactoryThrowsExceptionForInvalidType() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            TextAnalyzerFactory.getAnalyzer("invalidType");
        });

        String expectedMessage = "Invalid analysis type: invalidType";
        String actualMessage = exception.getMessage();
        assertTrue(actualMessage.contains(expectedMessage));
    }
}
