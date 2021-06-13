import { Injectable } from "@angular/core";
import { Adapter } from "../helpers/adapter";

export class Location {
    constructor(
        public id: number,
        public name: string,
    ) {}
}

@Injectable({
    providedIn: 'root'
})
export class LocationAdapter implements Adapter<Location> {
    adapt(item: any): Location {
        return new Location(
            item.id,
            item.name
        );
    }
}
