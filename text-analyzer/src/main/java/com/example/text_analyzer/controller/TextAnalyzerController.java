package com.example.text_analyzer.controller;

import com.example.text_analyzer.service.TextAnalyzerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Map;

@RestController
@RequestMapping("/api/analyses")
public class TextAnalyzerController {

    private static final Logger logger = LoggerFactory.getLogger(TextAnalyzerController.class);

    private final TextAnalyzerService textAnalyzerService;

    @Autowired
    public TextAnalyzerController(TextAnalyzerService textAnalyzerService) {
        this.textAnalyzerService = textAnalyzerService;
    }

    @GetMapping
    public ResponseEntity<Map<Character, Integer>> analyzeText(
            @RequestParam String type,
            @RequestParam String text) {
        logger.info("Received request to analyze text. Type: {}, Text: {}", type, text);
        Map<Character, Integer> result = textAnalyzerService.analyzeText(type, text);
        logger.info("Analysis result: {}", result);
        return ResponseEntity.ok(result);
    }

}
