import { bootstrapApplication } from '@angular/platform-browser';
import { provideHttpClient } from '@angular/common/http';
import { TextAnalyzerComponent } from './app/components/text-analyzer/text-analyzer.component';
import { provideAnimationsAsync } from '@angular/platform-browser/animations/async';

bootstrapApplication(TextAnalyzerComponent, {
  providers: [
    provideHttpClient(), provideAnimationsAsync()
  ]
}).catch(err => console.error(err));
