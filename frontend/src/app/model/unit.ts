import { Injectable } from "@angular/core";

@Injectable()
export class Unit{
    constructor(
        public id: number,
        public name: string
    ){}
}