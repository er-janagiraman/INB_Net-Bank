import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { AccountDetails } from 'src/app/pojo/account-details';
import { BankSlipDetails } from 'src/app/pojo/bank-slip';
import { ChequeDetails } from 'src/app/pojo/cheque-details';
import { CustomerService } from 'src/app/service/customer.service';
import { RegisterService } from 'src/app/service/register.service';

@Component({
  selector: 'app-cheque-request',
  templateUrl: './cheque-request.component.html',
  styleUrls: ['./cheque-request.component.css']
})
export class ChequeRequestComponent implements OnInit {

  chequeArr: ChequeDetails[] = [];
  accountDetails: AccountDetails[] = [];
  accountObj: AccountDetails = new AccountDetails();
  chequeDetails: ChequeDetails = new ChequeDetails();
  status: boolean = false;
  accountId: number = 0;
  bankSlip: BankSlipDetails = new BankSlipDetails();

  constructor(private router: Router, private RegisterService: RegisterService, private customerService: CustomerService) { }

  ngOnInit(): void {
    this.reloadData();
  }

  reloadData() {
    this.customerService.chequeStatus().subscribe(data => {
      this.chequeArr = data;
    });
  }

  details(cheque: any) {
    this.chequeDetails = cheque;
    this.accountId = cheque.accountId.accountId;
    this.customerService.getDataAcountId(this.accountId).subscribe(data => {
      this.accountObj = data;
    });
  }

  approve(chequeObj: ChequeDetails) {
    this.chequeDetails = chequeObj;
    this.bankSlip.chequeDetails = this.chequeDetails;
    this.chequeDetails.chequeStatus = 'cleared';
    this.bankSlip.accountId = chequeObj.accountId;
    this.bankSlip.accountIdTo = chequeObj.accountIdTo;
    this.bankSlip.chequeNo = chequeObj.chequeNo;
    this.customerService.approve(this.bankSlip).subscribe(data => {
      if (data == true)
        this.reloadData();
    });
  }

  decline(chequeObj: ChequeDetails) {
    this.chequeDetails = chequeObj;
    this.bankSlip.chequeDetails = this.chequeDetails;
    this.chequeDetails.chequeStatus = 'bounced';
    this.bankSlip.accountId = chequeObj.accountId;
    this.bankSlip.accountIdTo = chequeObj.accountIdTo;
    this.bankSlip.chequeNo = chequeObj.chequeNo;
    this.customerService.approve(this.bankSlip).subscribe(data => {
      if (data == true)
        this.reloadData();
    });
  }

}
