import { Component, OnInit } from '@angular/core';
import { AccountDetails } from 'src/app/pojo/account-details';
import { CustomerService } from 'src/app/service/customer.service';

@Component({
  selector: 'app-admin',
  templateUrl: './admin.component.html',
  styleUrls: ['./admin.component.css']
})
export class AdminComponent implements OnInit {

  getallEmployees: AccountDetails[] = [];
  customerId: string = '';

  constructor(private CustomerService: CustomerService) { }

  ngOnInit(): void {
  }

  reloadData() {
    this.CustomerService.getallcustomer().subscribe(data => {
      this.getallEmployees = data;
    });
  }

}
