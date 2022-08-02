import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { AccountDetails } from 'src/app/pojo/account-details';
import { ChequeDetails } from 'src/app/pojo/cheque-details';
import { CustomerService } from 'src/app/service/customer.service';

@Component({
  selector: 'app-cheque-deposit',
  templateUrl: './cheque-deposit.component.html',
  styleUrls: ['./cheque-deposit.component.css']
})
export class ChequeDepositComponent implements OnInit {

  customerId: string | null = '';
  chequeDetails: ChequeDetails[] = [];
  chequeDetail: ChequeDetails = new ChequeDetails();
  accountDetails: AccountDetails = new AccountDetails();
  constructor(private route: ActivatedRoute, private customerService: CustomerService, private router: Router) { }

  ngOnInit(): void {
    this.chequeDetail.accountId.accountId = this.route.snapshot.params['accountId'];
    this.customerId = localStorage.getItem('key');
    this.customerService.getCheque(this.chequeDetail.accountId.accountId).subscribe(data => {
      this.chequeDetails = data;
    });
    this.customerService.accDetailByAcc(this.chequeDetail.accountId.accountId).subscribe(data => {
      this.accountDetails = data;
    });
  }

  deposit() {
    this.chequeDetail.chequeStatus = "pending";
    this.customerService.chequeDeposit(this.chequeDetail).subscribe(data => {
      alert("Transcation Sucessful !!!!");
      this.router.navigate(['customer', this.customerId]);
    }, error => {
      alert("Server Issue Please try again !!!!");
    });

  }

  home() {
    this.router.navigate(['customer', this.customerId]);
  }

}
