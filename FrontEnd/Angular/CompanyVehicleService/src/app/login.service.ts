import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs'
import { Login } from './login/login.interface';

@Injectable({
  providedIn: 'root'
})
export class LoginService {

  constructor(private http: HttpClient) { }

  getStatus(username:string,password: string): Observable<Login>{
    return this.http.get<Login>('http://localhost:8080/finalProject/login?username='+username+'&'+'password='+password);
  }
}
