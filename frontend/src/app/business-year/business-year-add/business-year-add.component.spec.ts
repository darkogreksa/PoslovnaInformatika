import { ComponentFixture, TestBed } from '@angular/core/testing';

import { BusinessYearAddComponent } from './business-year-add.component';

describe('BusinessYearAddComponent', () => {
  let component: BusinessYearAddComponent;
  let fixture: ComponentFixture<BusinessYearAddComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ BusinessYearAddComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(BusinessYearAddComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
