import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ProductCardEditComponent } from './product-card-edit.component';

describe('ProductCardEditComponent', () => {
  let component: ProductCardEditComponent;
  let fixture: ComponentFixture<ProductCardEditComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ProductCardEditComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(ProductCardEditComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
