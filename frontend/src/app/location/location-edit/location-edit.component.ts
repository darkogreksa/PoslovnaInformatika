import { ThrowStmt } from '@angular/compiler';
import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormControl, FormGroup, Validators } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { Subscription } from 'rxjs';
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
  sub: Subscription;

  constructor(
    private locationService: LocationService, private route: ActivatedRoute, private router: Router) { }

  ngOnInit(): void {
    this.editLocationForm = new FormGroup({
      inputName: new FormControl()
    });
    this.sub = this.route.params.subscribe(params =>{
      const id = params['id'];
      if(id){
        this.locationService.getOne(id).subscribe((l: Location) =>{
          if(l){
            this.location = l;
          }else{
            alert("Ne postoji traženo mesto!")
          }
        });
      }
    });
  }

  edit(l: Location, id: number) {
    const name: string = this.editLocationForm.controls.inputName.value;

    this.location.name = name;
    this.locationService.edit(l, id).subscribe(location => {
      this.location;
      this.router.navigateByUrl("/location");
    });
  }

}