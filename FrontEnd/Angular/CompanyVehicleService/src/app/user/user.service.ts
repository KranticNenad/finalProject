import { Injectable } from "@angular/core";
import { User } from "./user.interface";
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';


@Injectable({
    providedIn: 'root'
})

export class UserService {

    constructor(private http: HttpClient) { }

    getUsers(): Observable<User[]>{
        return this.http.get<User[]>('http://localhost:8080/finalProject/users');
    }

    getUser(username: string): Observable<User>{
        return this.http.get<User>('http://localhost:8080/finalProject/users/' + username);
    }

    postUser(user: User): Observable<User> {
        return this.http.post<User>('http://localhost:8080/finalProject/users', user);
    }

    deleteUser(username: string): Observable<{}> {
        return this.http.delete('http://localhost:8080/finalProject/users/' + username);
    }

    putUser(user: User): Observable<User> {
        return this.http.put<User>('http://localhost:8080/finalProject/users', user);
    }
}