import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs'

@Injectable({
  providedIn: 'root'
})
export class LogoutService {

  constructor(private http: HttpClient) { }

  Logout(): Observable<{}>{
    return this.http.get('http://localhost:8080/finalProject/logout',{withCredentials: true});
  }
}
