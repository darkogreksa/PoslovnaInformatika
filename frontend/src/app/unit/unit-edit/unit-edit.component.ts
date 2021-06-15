import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormControl, FormGroup } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { Subscription } from 'rxjs';
import { Unit } from 'src/app/model/unit';
import { UnitService } from 'src/app/services/unit.service';

@Component({
  selector: 'app-unit-edit',
  templateUrl: './unit-edit.component.html',
  styleUrls: ['./unit-edit.component.css']
})
export class UnitEditComponent implements OnInit {

  unit!: Unit;
  editNameForm!: FormGroup;
  formBuilder!: FormBuilder;
  sub!: Subscription;

  constructor(private unitService: UnitService, private route: ActivatedRoute, private router: Router) { }

  ngOnInit(): void {
    this.editNameForm = new FormGroup({
      inputName: new FormControl()
    });
    this.sub = this.route.params.subscribe(params =>{
      const id = params['id'];
      if(id){
        this.unitService.getOne(id).subscribe((unit: Unit) =>{
          if(unit){
            this.unit = unit;
          }else{
            alert("Ne postoji trazena jedinica mere!")
          }
        });
      }
    });
  }

  edit(unit: Unit, id: number){
    const name: string = this.editNameForm.controls.inputName.value;

    this.unit.name = name;
    this.unitService.edit(unit, id).subscribe(unit => {
      this.unit;
      this.router.navigateByUrl("/units");
    });
    
  }


}
