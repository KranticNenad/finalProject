import { Employee } from './employee.interface';
import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class EmployeeService {

  constructor(private http: HttpClient) { }

  getEmployees(): Observable<Employee[]>{
    return this.http.get<Employee[]>('http://localhost:8080/finalProject/employees');
  }

  getEmployee(employeeId: number): Observable<Employee>{
    return this.http.get<Employee>('http://localhost:8080/finalProject/employees/'+employeeId);
  }

  postEmployee(employee: Employee):Observable<Employee>{
    return this.http.post<Employee>('http://localhost:8080/finalProject/employees/', employee);
  }


}
