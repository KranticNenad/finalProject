import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable, Subject } from 'rxjs'
import { Login } from './login/login.interface';
@Injectable({
  providedIn: 'root'
})
export class CheckService {
  subject: Subject<any>= new Subject();
  login:Login;
  constructor(private http: HttpClient) { }

  getStatus(): Observable<Login>{
    return this.http.get<Login>('http://localhost:8080/finalProject/check',{withCredentials: true});
  }

  getArgument(arg: any) {
    this.subject.next(arg);
    this.login = arg;
  }
  
}
 