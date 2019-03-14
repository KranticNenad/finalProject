import { Injectable } from "@angular/core";
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Location } from './location.interface';

@Injectable({
    providedIn: 'root'
})

export class LocationService {

    constructor(private http: HttpClient) { }

    getLocations(): Observable<Location[]> {
        return this.http.get<Location[]>('http://localhost:8080/finalProject/locations');
    }

    getLocation(locationCode: string): Observable<Location> {
        return this.http.get<Location>('http://localhost:8080/finalProject/locations' + locationCode);
    }

    postLocation(location: Location): Observable<Location>{
        return this.http.post<Location>('http://localhost:8080/finalProject/locations', location)
    }

    deleteLocation(locationCode: string): Observable<{}>{
        return this.http.delete('http://localhost:8080/finalProject/locations' + locationCode);
    }

    putLocation(location: Location): Observable<Location>{
        return this.http.put<Location>('http://localhost:8080/finalProject/locations', location);
    }
}