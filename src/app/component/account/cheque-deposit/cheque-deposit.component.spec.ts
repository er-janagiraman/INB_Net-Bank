import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ChequeDepositComponent } from './cheque-deposit.component';

describe('ChequeDepositComponent', () => {
  let component: ChequeDepositComponent;
  let fixture: ComponentFixture<ChequeDepositComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ChequeDepositComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(ChequeDepositComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
