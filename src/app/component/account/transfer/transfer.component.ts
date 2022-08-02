import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { AccountDetails } from 'src/app/pojo/account-details';
import { CustomerDetails } from 'src/app/pojo/customer-details';
import { TransactionDetails } from 'src/app/pojo/transaction-details';
import { CustomerService } from 'src/app/service/customer.service';

@Component({
  selector: 'app-transfer',
  templateUrl: './transfer.component.html',
  styleUrls: ['./transfer.component.css']
})
export class TransferComponent implements OnInit {

  userId: string = "";
  amount: number = 0;
  name: string = "";
  customerId: string | null = '';
  accounts: AccountDetails[] = [];
  accountDetails: AccountDetails = new AccountDetails();
  customerDetails: CustomerDetails = new CustomerDetails();
  transactionDetails: TransactionDetails = new TransactionDetails();
  result: boolean = false;

  constructor(private route: ActivatedRoute, private customerService: CustomerService, private router: Router) {
    this.userId = this.customerDetails.loginDetails.userId;
  }

  ngOnInit(): void {
    this.accountDetails.accountId = this.route.snapshot.params['accountId'];
    this.customerId = localStorage.getItem('key');
    this.customerService.accDetailByAcc(this.accountDetails.accountId).subscribe(data => {
      this.accountDetails = data;
    });
  }

  transfer() {
    this.transactionDetails.accountId.accountId = this.accountDetails.accountId;
    if (this.accountDetails.currentBalance >= this.transactionDetails.transactionAmount) {
      this.customerService.dataAcountId(this.transactionDetails).subscribe(data => {
        this.result = data;
        if (data == true) {
          alert("Transcation Success !!!!");
          this.router.navigate(['customer', this.customerId]);
        }
      });
    } else {
      alert("Insufficient Balance !!!!");
      this.router.navigate(['customer', this.customerId]);
    }
  }

  home() {
    this.router.navigate(['customer', this.customerId]);
  }
}
