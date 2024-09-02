import { Component } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { TextAnalyzerOfflineService } from '../../services/text-analyzer-offline.service';
import { TextAnalyzerApiService } from '../../services/text-analyzer-api.service';
import { AnalysisResult } from '../../models/analysis-result.model';
import { MatSnackBarModule, MatSnackBar } from '@angular/material/snack-bar';

@Component({
  selector: 'app-text-analyzer',
  standalone: true,
  imports: [CommonModule, FormsModule, MatSnackBarModule],
  templateUrl: './text-analyzer.component.html',
  styleUrl: './text-analyzer.component.css'
})
export class TextAnalyzerComponent {
  text: string = '';
  analysisResult: AnalysisResult | null = null;
  analysisType: 'vowels' | 'consonants' = 'vowels';
  mode: 'offline' | 'online' = 'offline';
  analysisHistory: string[] = [];

  constructor(
    private offlineService: TextAnalyzerOfflineService,
    private apiService: TextAnalyzerApiService,
    private snackBar: MatSnackBar
  ) {}

  analyzeText(): void {
    if (this.text.length === 0) {
      this.snackBar.open('You need to input some text', 'Close', {
        duration: 2000,
        horizontalPosition: 'right',
        verticalPosition: 'top',
      });
      return;
    }
    if (this.mode === 'online') {
      this.apiService.analyzeTextOnline(this.analysisType as 'vowels' | 'consonants', this.text).subscribe({
        next: (result) => {
          this.analysisHistory.push(this.formatAnalyzedText(result));
          this.text = '';
        },
        error: () => {
          this.snackBar.open('An error occurred during analysis. Please try again.', 'Close', {
            duration: 2000,
            horizontalPosition: 'right',
            verticalPosition: 'top',
          });
        }
      });
    } else {
      this.analysisResult = this.offlineService.analyzeTextOffline(this.analysisType as 'vowels' | 'consonants', this.text);
      this.analysisHistory.push(this.formatAnalyzedText(this.analysisResult));
      this.text = '';
    }
  }

  private formatAnalyzedText(analysisResult: AnalysisResult): string {
    return `The ${this.mode} analysis for the word "${this.text}" is:\n${this.formatResult(analysisResult)}`;
  }

  private formatResult(result: AnalysisResult): string {
    if (!result || Object.keys(result).length === 0) {
        return `No ${this.analysisType} in this text`;
    }
    
    return Object.entries(result)
      .sort(([keyA], [keyB]) => keyA.localeCompare(keyB))
      .map(([key, value]) => `${key}: ${value}`)
      .join('\n');
}
  
}

