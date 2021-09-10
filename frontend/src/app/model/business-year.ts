import { Injectable } from "@angular/core";
import { Company } from "./company";

@Injectable()
export class BusinessYear {
    constructor(    
        public closed: boolean,
        public company: Company,
        public id : number,
        public year: string
    ) {}
}
