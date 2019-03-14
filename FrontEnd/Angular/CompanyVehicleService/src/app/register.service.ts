import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { User } from './user/user.interface';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class RegisterService {


  constructor(private http: HttpClient) {         
  }

  postUser(user: User): Observable<User> {
        return this.http.post<User>('http://localhost:8080/finalProject/users', user);
    }
  }
