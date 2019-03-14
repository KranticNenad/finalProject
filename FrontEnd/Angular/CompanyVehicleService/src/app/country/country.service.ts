import { Country } from './country.interface';
import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class CountryService {

  constructor(private http: HttpClient) { }

  getCountries(): Observable<Country[]>{
    return this.http.get<Country[]>('http://localhost:8080/finalProject/countries');
  }

  getCountry(countryCode: string): Observable<Country>{
    return this.http.get<Country>('http://localhost:8080/finalProject/countries/'+countryCode);
  }

  postCountry(country: Country):Observable<Country>{
    return this.http.post<Country>('http://localhost:8080/finalProject/countries/', country);
  }

  deleteCountry(countryCode: string): Observable<{}>{
    return this.http.delete('http://localhost:8080/finalProject/countries/'+countryCode);
  }

  putCountry(country: Country): Observable<Country>{
    return this.http.put<Country>('http://localhost:8080/finalProject/countries/', country);
  }
}
