import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup } from '@angular/forms';
import { Router } from '@angular/router';
import { Unit } from 'src/app/model/unit';
import { UnitService } from 'src/app/services/unit.service';

@Component({
  selector: 'app-unit-add',
  templateUrl: './unit-add.component.html',
  styleUrls: ['./unit-add.component.css']
})
export class UnitAddComponent implements OnInit {

  u: Unit;
  addNameForm: FormGroup;

  constructor(private unitService: UnitService, private router: Router) { }

  ngOnInit(): void {
    this.addNameForm = new FormGroup({
      inputName: new FormControl()
    });
  }

  onSubmit(){
    const name: string = this.addNameForm.controls.inputName.value;
    this.u = new Unit(0, name);
    this.unitService.add(this.u).subscribe(u => {
      this.u;
      this.router.navigateByUrl("/unit");
    });
  }

}
