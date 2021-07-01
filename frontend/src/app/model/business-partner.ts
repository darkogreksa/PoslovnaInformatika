import { Injectable } from "@angular/core";

@Injectable()
export class BusinessPartner {
    constructor(    
        public id : number,
        public name: string,
        public pib: string,
        public address: string
    ) {}
}
