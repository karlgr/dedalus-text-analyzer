import { Injectable } from '@angular/core';
import { AnalysisResult, Character } from '../models/analysis-result.model'

@Injectable({
  providedIn: 'root'
})
export class TextAnalyzerOfflineService {
  
  private readonly vowels: Set<string> = new Set('AEIOU');
  private readonly consonants: Set<string> = new Set('BCDFGHJKLMNPQRSTVWXYZ');

  analyzeTextOffline(type: 'vowels' | 'consonants', text: string): AnalysisResult {
    const result: AnalysisResult = {};
    const normalizedText = text.toUpperCase();

    let charactersToAnalyze: Set<string>;

    switch (type) {
      case 'vowels':
        charactersToAnalyze = this.vowels;
        break;
      case 'consonants':
        charactersToAnalyze = this.consonants;
        break;
      default:
        throw new Error(`Unknown analysis type: ${type}`);
    }

    for (const char of normalizedText) {
      if (charactersToAnalyze.has(char as Character)) {
        const key = char as Character;
        result[key] = (result[key] || 0) + 1;
      }
    }

    return result;
  }
}
