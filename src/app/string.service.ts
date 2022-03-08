import { Injectable } from '@angular/core';
import { HttpClient  } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Strings } from './strings';
import { environment } from 'src/environments/environment';

@Injectable({
  providedIn: 'root'
})
export class StringService {


  constructor(private http: HttpClient) { }

  private apiServerUrl = environment.apiBaseUrl;

  public getStrings(): Observable<Strings[]> {
    return this.http.get<Strings[]>(`${this.apiServerUrl}/string/all`);
  }

  public addStrings(strings: String): Observable<String> {
    return this.http.post<String>(`${this.apiServerUrl}/string/add`, strings);
  }

  public deleteString(stringId: number): Observable<void>{
    return this.http.delete<void>(`${this.apiServerUrl}/string/delete/${stringId}`);
  }



}
