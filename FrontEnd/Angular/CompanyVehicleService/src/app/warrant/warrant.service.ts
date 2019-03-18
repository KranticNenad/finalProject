import { Warrant } from './warrant.interface';
import { Injectable } from "@angular/core";
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { WarrantDto } from './warrant-dto.interface';

@Injectable({
    providedIn: 'root'
})

export class WarrantService {

    constructor(private http: HttpClient) {}

    getWarrants(): Observable<Warrant[]>{
        return this.http.get<Warrant[]>('http://localhost:8080/finalProject/warrants');
    }

    getWarrant(warrantId: number): Observable<Warrant>{
        return this.http.get<Warrant>('http://localhost:8080/finalProject/warrants/' + warrantId);
    }

    postWarrant(warrantDto: WarrantDto): Observable<Warrant>{
        return this.http.post<Warrant>('http://localhost:8080/finalProject/warrants', warrantDto);
    }

    deleteWarrant(warrantId: number): Observable<{}>{
        return this.http.delete('http://localhost:8080/finalProject/warrants/' + warrantId);
    }

    putWarrant(warrantDto: WarrantDto): Observable<Warrant>{
        return this.http.put<Warrant>('http://localhost:8080/finalProject/warrants', warrantDto);
    }





}