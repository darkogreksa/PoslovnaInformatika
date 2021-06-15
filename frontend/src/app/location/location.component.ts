import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup } from '@angular/forms';
import { Location } from '../model/location';
import { LocationService } from '../services/location.service';

@Component({
  selector: 'app-location',
  templateUrl: './location.component.html',
  styleUrls: ['./location.component.css']
})
export class LocationComponent implements OnInit {
  allLocations: Location[] = [];
  searchLocationsForm!: FormGroup;

  constructor(private locationService: LocationService) {
    this.locationService.getAll().subscribe(
      (locations: Location[]) => {
        this.allLocations = locations;
      },
      (error) => console.log(error)
    ); }

  ngOnInit() {
    this.searchLocationsForm = new FormGroup({
      searchQuery: new FormControl()
    });
  }

  loggedIn(): boolean {
    return true;
  }
  isAdmin(): boolean {
    return true;
  }

  delete(id: number) {
    this.locationService.deleteLocation(id).subscribe(() => {
      for (let i = 0; i < this.allLocations.length; i++) {
        if (this.allLocations[i].id === id) {
          this.allLocations.splice(i, 1);
        }
      }
    });
  }

}
