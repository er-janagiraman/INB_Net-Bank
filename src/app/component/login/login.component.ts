import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { CustomerDetails } from 'src/app/pojo/customer-details';
import { LoginDetails } from 'src/app/pojo/login-details';
import { LoginService } from 'src/app/service/login.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  customerDetails: CustomerDetails = new CustomerDetails();
  login: LoginDetails = new LoginDetails();
  error: string = "";
  server: string = "";
  note: string = "";
  customerId: string = "";

  constructor(private loginService: LoginService, private router: Router) { }

  ngOnInit(): void {
  }

  loginBtn(userId: string) {
    this.loginService.getLoginData(userId).subscribe(data => {
      
      if (data.customerStatus == "approved") {
        this.customerDetails = data;
        this.loginService.login(this.login).subscribe(data => {
          this.login = data;
          if (data.role == "customer") {
            this.router.navigate(['customer', this.customerDetails.customerId]);
          }
          else if (data.role == "admin") {
            this.router.navigate(['admin']);
          } else {
            this.error = "Invalid UserName and Password !!!! Please try again"
          }
        }, error => {
          this.server = "Invalid UserName and Password !!!! Please try again";
         
        });

      } else {
        this.note = "Please check your Status !!!";
      }
    });

  }

  newLogin() {
    this.router.navigate(['newLogin']);
  }

  checkStatus() {
    this.router.navigate(['validateStatus']);
  }


}
