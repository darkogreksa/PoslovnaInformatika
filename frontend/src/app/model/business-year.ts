import { Injectable } from "@angular/core";
import { Company } from "./company";

@Injectable({providedIn: 'root'})
export class BusinessYear {
    constructor(
        public id: number,
        public year: string,
        public company: Company,
        public closed: boolean
    ){}
}
