import { HttpClient } from "@angular/common/http";
import { Observable } from "rxjs";
import { Unit } from "../model/unit";
import { Injectable } from "@angular/core";


@Injectable({providedIn: 'root'})
export class UnitService{

    private baseURL = "http://localhost:8080/api/unit";
    constructor(
        private http: HttpClient
    ){}

    getAll(): Observable<Unit[]>{
        const url = this.baseURL;
        return this.http.get<Unit[]>(url).pipe();
    }

    getOne(id: number){
        return this.http.get<Unit>(this.baseURL + '/'+id);
    }

    add(u: Unit){
        return this.http.post<Unit>(this.baseURL + '/create', u);
    }

    edit(u: Unit, id: number){
        const url = `${this.baseURL}/update/`+id;
        return this.http.put(url, u);
    }

    delete(id: number){
        return this.http.delete(this.baseURL + '/' + id);
    }

}