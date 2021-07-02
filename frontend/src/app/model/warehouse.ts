import { Injectable } from "@angular/core";
import { Company } from "./company";

@Injectable()
export class Warehouse{
    constructor(
        public id: number,
        public name: string,
        public company: Company
    ){}
}
