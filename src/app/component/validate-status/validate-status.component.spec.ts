import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ValidateStatusComponent } from './validate-status.component';

describe('ValidateStatusComponent', () => {
  let component: ValidateStatusComponent;
  let fixture: ComponentFixture<ValidateStatusComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ValidateStatusComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(ValidateStatusComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
