import { Component, OnInit } from '@angular/core';
import { Unit } from '../model/unit';
// import { UnitService } from '../services/unit.service';

@Component({
  selector: 'app-unit',
  templateUrl: './unit.component.html',
  styleUrls: ['./unit.component.css']
})
export class UnitComponent implements OnInit {

  all: Unit[] = [];

  constructor() {}

  ngOnInit(): void {}

}
