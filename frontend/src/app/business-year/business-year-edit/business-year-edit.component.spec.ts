import { ComponentFixture, TestBed } from '@angular/core/testing';

import { BusinessYearEditComponent } from './business-year-edit.component';

describe('BusinessYearEditComponent', () => {
  let component: BusinessYearEditComponent;
  let fixture: ComponentFixture<BusinessYearEditComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ BusinessYearEditComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(BusinessYearEditComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
