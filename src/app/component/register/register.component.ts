import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { CustomerDetails } from 'src/app/pojo/customer-details';
import { LoginDetails } from 'src/app/pojo/login-details';
import { RegisterService } from 'src/app/service/register.service';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent implements OnInit {

  customerDetails: CustomerDetails = new CustomerDetails();
  status: string = "";
  Error: string = "";

  loginDetails: LoginDetails = new LoginDetails();
  constructor(private registerService: RegisterService, private router: Router) {
  }

  ngOnInit(): void {
    this.loginDetails = JSON.parse(sessionStorage.getItem('customer') || '');

    this.customerDetails.loginDetails = this.loginDetails;
  }

  registerBtn(userId: string) {
    this.customerDetails.customerStatus = "pending";
    this.registerService.addRegister(this.customerDetails).subscribe(data => {
      if (data == true) {
        sessionStorage.setItem('customer', JSON.stringify(this.customerDetails));
        this.router.navigate(['newAcc', userId]);
      }
      else
        this.status = "Account Not added !!!! Please try again";
    }, Error => {
      this.Error = "Server Error !!!! Please try again after some time"
    }
    );
  }
}
