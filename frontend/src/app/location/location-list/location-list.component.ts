import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup } from '@angular/forms';
import { Location } from 'src/app/model/location';
import { LocationService } from 'src/app/services/location.service';

@Component({
  selector: 'app-location',
  templateUrl: './location-list.component.html',
  styleUrls: ['./location-list.component.css']
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
    this.locationService.delete(id).subscribe(() => {
      for (let i = 0; i < this.allLocations.length; i++) {
        if (this.allLocations[i].id === id) {
          this.allLocations.splice(i, 1);
        }
      }
    });
  }

  search(name){
   this.locationService.getAllByName(name).subscribe(
      (p: Location[]) =>{
         this.allLocations = p;
         console.log(p);
      },
        (error) => console.log(error)
      );
    console.log(name);
  }

}
