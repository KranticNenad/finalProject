import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Car } from './car.interface';

@Injectable({
  providedIn: 'root'
})
export class CarService {

  constructor(private http: HttpClient) { }

  getCars(): Observable<Car[]> {
    return this.http.get<Car[]>('http://localhost:8080/finalProject/cars');
  }

  // getCar(regNo: string): Observable<Car> {
  //   return this.http.get<Car>('http://localhost:8080/finalProject/cars/' + regNo);
  // }
}
