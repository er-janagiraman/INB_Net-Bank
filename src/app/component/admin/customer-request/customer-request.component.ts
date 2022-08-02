import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { AccountDetails } from 'src/app/pojo/account-details';
import { CustomerDetails } from 'src/app/pojo/customer-details';
import { CustomerService } from 'src/app/service/customer.service';
import { RegisterService } from 'src/app/service/register.service';

@Component({
  selector: 'app-customer-request',
  templateUrl: './customer-request.component.html',
  styleUrls: ['./customer-request.component.css']
})
export class CustomerRequestComponent implements OnInit {

  customerdetails: CustomerDetails[] = [];
  accountDetails: AccountDetails[] = [];
  accountObj: AccountDetails = new AccountDetails();
  customerObj: CustomerDetails = new CustomerDetails();
  result: boolean = false;
  submitted: boolean = false;
  customerId: string = '';
  customerResult: boolean = false;

  constructor(private router: Router, private RegisterService: RegisterService, private customerService: CustomerService) { }

  ngOnInit(): void {
    this.reloadData();
  }

  reloadData() {
    this.customerService.getallcustomer().subscribe(data => {
      this.accountDetails = data;
    });
  }

  approve(accept: any) {
    this.accountObj = accept;
    this.accountObj.accountStatus = "approved";
    this.RegisterService.approve(this.accountObj).subscribe(data => {
      if (data == true)
        this.reloadData();
    });
    this.accountObj.customerDetails.customerStatus = "approved";
    this.RegisterService.customerApproved(this.accountObj.customerDetails).subscribe(data => {
      this.customerResult = data;
    });
    this.customerService.customerIdDetails(this.accountObj.customerDetails.customerId).subscribe(data => {
      this.customerService.mailVerification(data).subscribe(data => {
      });
    });
  }

  decline(accept: any) {
    this.accountObj = accept
    this.accountObj.accountStatus = "decline";
    this.RegisterService.decline(this.accountObj).subscribe(data => {
      this.result = data;
      if (this.result == true)
        this.reloadData();
    })
    this.accountObj.customerDetails.customerStatus = "decline";
    this.RegisterService.customerDecline(this.accountObj.customerDetails).subscribe(data => {
      this.customerResult = data;
    });
    this.customerService.customerIdDetails(this.accountObj.customerDetails.customerId).subscribe(data => {
      this.customerService.mailVerification(data).subscribe(data => {
      });
    });

  }

}
