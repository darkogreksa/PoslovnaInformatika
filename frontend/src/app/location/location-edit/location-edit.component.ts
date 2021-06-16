import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { Location } from 'src/app/model/location';
import { LocationService } from 'src/app/services/location.service';

@Component({
  selector: 'app-location-edit',
  templateUrl: './location-edit.component.html',
  styleUrls: ['./location-edit.component.css']
})
export class LocationEditComponent implements OnInit {
  editLocationForm: FormGroup;
  location: Location;

  constructor(
    private locationService: LocationService,
    private formBuilder: FormBuilder,
    private router: Router,
    private route: ActivatedRoute
  ) { }

  ngOnInit() {
    this.createForm();
    this.route.params.subscribe(params => {
      const id = params['id'];
      if(id) {
        this.locationService.getOne(id).subscribe((l: Location) => {
          if(l) {
            this.location = l;
            this.editLocationForm.controls['name'].setValue(l.name)
          }
        });
      }
    });
  }

  createForm() {
    this.editLocationForm = this.formBuilder.group({
      name: ['', Validators.required]
    });
  }

  onSubmit() {
    const name: string = this.editLocationForm.controls.name.value;

    this.location.name = name;

    this.locationService.editLocation(this.location)
  }

}
