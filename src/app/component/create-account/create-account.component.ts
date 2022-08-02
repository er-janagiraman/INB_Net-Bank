import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { AccountDetails } from 'src/app/pojo/account-details';
import { CustomerDetails } from 'src/app/pojo/customer-details';
import { LoginDetails } from 'src/app/pojo/login-details';
import { CustomerService } from 'src/app/service/customer.service';

@Component({
  selector: 'app-create-account',
  templateUrl: './create-account.component.html',
  styleUrls: ['./create-account.component.css']
})
export class CreateAccountComponent implements OnInit {

  customerDetails: CustomerDetails = new CustomerDetails();
  accountDetails: AccountDetails = new AccountDetails();
  status: string = "";
  Error: string = "";
  userId: string = "";

  loginDetails: LoginDetails = new LoginDetails();

  constructor(private customerService: CustomerService, private router: Router, private route: ActivatedRoute) { }

  ngOnInit(): void {
    this.loginDetails = JSON.parse(sessionStorage.getItem('customer') || '');
    this.customerDetails.loginDetails = this.loginDetails;
    this.userId = this.route.snapshot.params['userId'];

  }

  registerBtn() {
    if(this.accountDetails.typeOfAccount = "savings"){
      this.accountDetails.rateOfInterest=3.5;
    }
    this.customerService.checkStatus(this.userId).subscribe(data => {
      this.customerDetails = data;
      this.accountDetails.customerDetails = this.customerDetails;
      this.accountDetails.accountStatus = "pending";
      this.accountDetails.customerDetails.customerStatus = "pending";
      this.customerService.addAccount(this.accountDetails).subscribe(data => {
        if (data == true) {
          this.router.navigate(['status']);
        }
      });
    });
  }

}
