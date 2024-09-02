import { TestBed } from '@angular/core/testing';
import { TextAnalyzerOfflineService } from './text-analyzer-offline.service';
import { AnalysisResult } from '../models/analysis-result.model';

describe('TextAnalyzerOfflineService', () => {
  let service: TextAnalyzerOfflineService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(TextAnalyzerOfflineService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });

  describe('analyzeTextOffline', () => {
    it('should correctly count vowels in the text', () => {
      const text = 'Hello World';
      const expectedResult: AnalysisResult = { E: 1, O: 2 };

      const result = service.analyzeTextOffline('vowels', text);

      expect(result).toEqual(expectedResult);
    });

    it('should correctly count consonants in the text', () => {
      const text = 'Hello World';
      const expectedResult: AnalysisResult = { H: 1, L: 3, W: 1, R: 1, D: 1 };

      const result = service.analyzeTextOffline('consonants', text);

      expect(result).toEqual(expectedResult);
    });

    it('should handle text with mixed case letters correctly', () => {
      const text = 'HeLLo wOrLD';
      const expectedResult: AnalysisResult = { H: 1, L: 3, W: 1, R: 1, D: 1 };

      const result = service.analyzeTextOffline('consonants', text);

      expect(result).toEqual(expectedResult);
    });

    it('should return an empty result if there are no vowels or consonants in the text', () => {
      const text = '1234 !@#$';
      const expectedVowelResult: AnalysisResult = {};
      const expectedConsonantResult: AnalysisResult = {};

      const vowelResult = service.analyzeTextOffline('vowels', text);
      const consonantResult = service.analyzeTextOffline('consonants', text);

      expect(vowelResult).toEqual(expectedVowelResult);
      expect(consonantResult).toEqual(expectedConsonantResult);
    });

    it('should ignore characters that are neither vowels nor consonants', () => {
      const text = 'A1!B2@C3#';
      const expectedVowelResult: AnalysisResult = { A: 1 };
      const expectedConsonantResult: AnalysisResult = { B: 1, C: 1 };

      const vowelResult = service.analyzeTextOffline('vowels', text);
      const consonantResult = service.analyzeTextOffline('consonants', text);

      expect(vowelResult).toEqual(expectedVowelResult);
      expect(consonantResult).toEqual(expectedConsonantResult);
    });

    it('should throw an error if an unknown analysis type is provided', () => {
      const text = 'Hello World';
      
      expect(() => service.analyzeTextOffline('unknownType' as any, text))
        .toThrowError('Unknown analysis type: unknownType');
    });

    it('should handle an empty string gracefully', () => {
      const text = '';
      const expectedVowelResult: AnalysisResult = {};
      const expectedConsonantResult: AnalysisResult = {};

      const vowelResult = service.analyzeTextOffline('vowels', text);
      const consonantResult = service.analyzeTextOffline('consonants', text);

      expect(vowelResult).toEqual(expectedVowelResult);
      expect(consonantResult).toEqual(expectedConsonantResult);
    });
  });
});
