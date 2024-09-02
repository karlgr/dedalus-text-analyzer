import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { AnalysisResult } from '../models/analysis-result.model';

@Injectable({
  providedIn: 'root'
})
export class TextAnalyzerApiService {

  private apiUrl = 'http://localhost:8080/api/analyses';

  constructor(private http: HttpClient) { }

  analyzeTextOnline(type: 'vowels' | 'consonants', text: string): Observable<AnalysisResult> {
    return this.http.get<AnalysisResult>(`${this.apiUrl}?type=${type}&text=${text}`);
  }
}