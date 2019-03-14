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

  getCar(regNo: string): Observable<Car> {
    return this.http.get<Car>('http://localhost:8080/finalProject/cars/' + regNo);
  }

  postCat(car: Car): Observable<Car> {
    return this.http.post<Car>('http://localhost:8080/finalProject/cars', car);
  }
  
  deleteCar(regNo: string): Observable<{}> {
    return this.http.delete('http://localhost:8080/finalProject/cars' + regNo)
  }

  putCar(car: Car): Observable<Car> {
    return this.http.put<Car>('http://localhost:8080/finalProject/cars', car);
  }

}
