import { Injectable } from "@angular/core";

@Injectable()
export class Company {
    constructor(
        public name: string,
        public pib: string,
        public address: string
    ) {}
}
