import { ComponentFixture, TestBed } from '@angular/core/testing';

import { BusinessYearComponent } from './business-year.component';

describe('BusinessYearComponent', () => {
  let component: BusinessYearComponent;
  let fixture: ComponentFixture<BusinessYearComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ BusinessYearComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(BusinessYearComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
