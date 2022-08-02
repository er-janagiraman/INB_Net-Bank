import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { CustomerDetails } from 'src/app/pojo/customer-details';
import { LoginDetails } from 'src/app/pojo/login-details';
import { CustomerService } from 'src/app/service/customer.service';
import { LoginService } from 'src/app/service/login.service';

@Component({
  selector: 'app-validate-status',
  templateUrl: './validate-status.component.html',
  styleUrls: ['./validate-status.component.css']
})
export class ValidateStatusComponent implements OnInit {

  checkLogin: LoginDetails = new LoginDetails();
  customerDetails: CustomerDetails = new CustomerDetails();
  status: string = "";
  Error: string = "";

  constructor(private loginService: LoginService, private router: Router, private customerService: CustomerService) { }

  ngOnInit(): void {
  }

  loginBtn() {
    this.loginService.login(this.checkLogin).subscribe(data => {
      this.checkLogin = data;
      if (this.checkLogin.userId != "") {

        this.customerService.checkStatus(this.checkLogin.userId).subscribe(data => {
          this.customerDetails = data;
          sessionStorage.setItem('customer', JSON.stringify(this.customerDetails));
          this.router.navigate(['status']);
        });
      }
    }, error => {
      this.Error = "Invalid UserName and Password !!!! Please try again";
    });
  }

}
