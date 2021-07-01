import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { map } from 'rxjs/operators';
import { LocationAdapter, Location } from '../model/location';

@Injectable({
  providedIn: 'root'
})
export class LocationService {
  private baseUrl = 'http://localhost:8080/api/location';

  constructor(
    private http: HttpClient,
    private adapter: LocationAdapter
  ) { }

  getAll(): Observable<Location[]> {
    const url = `${this.baseUrl}/`;
    return this.http.get<Location[]>(url).pipe(
      map((data: any[]) => data.map(item => this.adapter.adapt(item)))
    );
  }

  getOne(id: number) {
    return this.http.get(this.baseUrl + '/' + id);
  }

  add(location: Location) {
    return this.http.post<Location>(this.baseUrl + '/create', location);
  }

  edit(location: Location, id: number) {
    const url = `${this.baseUrl}/update/`+id;
    return this.http.put(url, location);
  }

  delete(id: number) {
    return this.http.delete(this.baseUrl + '/' + id);
  }
}
