import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { AccountDetails } from 'src/app/pojo/account-details';
import { CustomerDetails } from 'src/app/pojo/customer-details';
import { CustomerService } from 'src/app/service/customer.service';

@Component({
  selector: 'app-customer-details',
  templateUrl: './customer-details.component.html',
  styleUrls: ['./customer-details.component.css']
})
export class CustomerDetailsComponent implements OnInit {
  customerId: string = "";
  customerdetails: CustomerDetails = new CustomerDetails();
  allAccountDetails: AccountDetails[] = [];
  constructor(private CustomerService: CustomerService, private route: ActivatedRoute, private router: Router) {
  }

  ngOnInit(): void {
    this.customerId = this.route.snapshot.params['customerId'];
    localStorage.setItem('key', this.customerId);

    this.CustomerService.customerIdDetails(this.customerId).subscribe(data => {
      this.customerdetails = data;
    });

    this.CustomerService.getcustomerdetailsbycustomerid(this.customerId).subscribe(data => {
      this.allAccountDetails = data;
    });


  }

  addAccount(customerId: string) {
    this.router.navigate(['addAccount', customerId]);
  }

  transfer(accountId: number) {
    this.router.navigate(['transfer', accountId]);
  }

  deposit(accountId: number) {
    this.router.navigate(['cheque', accountId]);
  }
  transaction(accountId: number) {
    this.router.navigate(['transaction', accountId]);
  }

}
