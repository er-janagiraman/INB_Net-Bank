import { Component, OnInit } from '@angular/core';
import { AccountDetails } from 'src/app/pojo/account-details';
import { CustomerDetails } from 'src/app/pojo/customer-details';
import { LoginDetails } from 'src/app/pojo/login-details';
import { CustomerService } from 'src/app/service/customer.service';

@Component({
  selector: 'app-status',
  templateUrl: './status.component.html',
  styleUrls: ['./status.component.css']
})
export class StatusComponent implements OnInit {

  customerDetails: CustomerDetails = new CustomerDetails();
  loginDetails: LoginDetails = new LoginDetails();
  accountDetails: AccountDetails = new AccountDetails();

  constructor(private customerService: CustomerService) { }

  ngOnInit(): void {

    this.customerDetails = JSON.parse(sessionStorage.getItem("customer") || '');

    this.customerService.checkStatus(this.customerDetails.loginDetails.userId).subscribe(data => {
      this.customerDetails = data;
    });

  }


}
