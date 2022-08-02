import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { AccountDetails } from 'src/app/pojo/account-details';
import { CustomerDetails } from 'src/app/pojo/customer-details';
import { LoginDetails } from 'src/app/pojo/login-details';
import { CustomerService } from 'src/app/service/customer.service';

@Component({
  selector: 'app-add-account',
  templateUrl: './add-account.component.html',
  styleUrls: ['./add-account.component.css']
})
export class AddAccountComponent implements OnInit {

  maturityAmount: number = 0;
  fdAmount: number = 0;
  duration: number = 0;
  fd: boolean = false;
  customerDetails: CustomerDetails = new CustomerDetails();
  accountDetails: AccountDetails = new AccountDetails();
  status: string = "";
  Error: string = "";
  loginDetails: LoginDetails = new LoginDetails();
  accountDetail: AccountDetails[] = [];
  accDetail: AccountDetails = new AccountDetails();
  newFdAccountDetails: AccountDetails = new AccountDetails();

  constructor(private customerService: CustomerService, private router: Router, private route: ActivatedRoute) { }

  ngOnInit(): void {
    this.accountDetails.customerDetails.customerId = this.route.snapshot.params['customerId'];
    this.customerService.getcustomerdetailsbycustomerid(this.accountDetails.customerDetails.customerId).subscribe(data => {
      this.accountDetail = data;
    });


  }

  addAccount() {
    if (this.accountDetails.typeOfAccount == "fd") {
      this.newFdAccountDetails.customerDetails.customerId = this.accountDetails.customerDetails.customerId;
      this.newFdAccountDetails.accountId = this.accountDetails.accountId;
      this.newFdAccountDetails.accountStatus = "approved";
      this.newFdAccountDetails.currentBalance = this.fdAmount;
      this.newFdAccountDetails.openingDate = new Date();
      if (this.duration == 1)
        this.newFdAccountDetails.rateOfInterest = 4.5;
      else if (this.duration == 2)
        this.newFdAccountDetails.rateOfInterest = 5.0;
      else (this.duration == 3)
      this.newFdAccountDetails.rateOfInterest = 5.5;
      this.newFdAccountDetails.typeOfAccount = "fd";
      this.customerService.createAccount(this.newFdAccountDetails).subscribe(data => {
        if (data == true)
          alert(" FD Account  created Successfully !!!!");
      }, error => {
        alert(" Server Issue !!!!");
      }
      );
    }
    else {
      this.accountDetails.accountStatus = "pending";
      this.customerService.createAccount(this.accountDetails).subscribe(data => {
        if (data == true) {
          alert("Account Added Successful !!!!");
          this.router.navigate(['customer', this.accountDetails.customerDetails.customerId]);
        } else {
          alert("Server issue, Please try again !!!!");
        }
      }, error => {
        this.Error = "Server issue, Please try again !!!!";
      }
      );
    }
  }

  home(userId: string) {
    this.router.navigate(['customer', userId]);
  }

  fdd() {
    if (this.accountDetails.typeOfAccount == "fd")
      this.fd = true;
  }

  acc(accountId: number) {
    this.customerService.accDetailByAcc(accountId).subscribe(data => {
      this.accDetail = data;
    });
  }

  calculation() {
    if (this.duration == 1) {
      this.maturityAmount = (this.fdAmount * 1.045 * 1) / 100;
    }
    else if (this.duration == 2) {
      this.maturityAmount = (this.fdAmount * 1.050 * 2) / 100;
    }
    else if (this.duration == 3)
      this.maturityAmount = (this.fdAmount * 1.055 * 3) / 100;
  }


}
