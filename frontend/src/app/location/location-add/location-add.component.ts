import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Location } from 'src/app/model/location';
import { LocationService } from 'src/app/services/location.service';

@Component({
  selector: 'app-location-add',
  templateUrl: './location-add.component.html',
  styleUrls: ['./location-add.component.css']
})
export class LocationAddComponent implements OnInit {
  
  addLocationForm: FormGroup;
  location: Location;

  constructor(
    private locationService: LocationService,
    private formBuilder: FormBuilder
  ) { }

  ngOnInit() {
    this.createForm();
  }

  createForm() {
    this.addLocationForm = this.formBuilder.group({
      name: ['', Validators.required]
    });
  }

  onSubmit() {
    const name: string = this.addLocationForm.controls.name.value;

    this.location = new Location(0, name);

    this.locationService.addLocation(this.location).subscribe(location => this.location);
  }

}
