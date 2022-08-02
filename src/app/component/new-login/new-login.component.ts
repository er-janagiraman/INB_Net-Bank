import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { LoginDetails } from 'src/app/pojo/login-details';

import { LoginService } from 'src/app/service/login.service';

@Component({
  selector: 'app-new-login',
  templateUrl: './new-login.component.html',
  styleUrls: ['./new-login.component.css']
})
export class NewLoginComponent implements OnInit {

  newLogin: LoginDetails = new LoginDetails();
  status: string = "";
  Error: string = "";
  userId: string = "";

  constructor(private loginService: LoginService, private router: Router) { }

  ngOnInit(): void {

    this.loginService.getNextUserId().subscribe(
      data => {
       
        this.newLogin = data;
        this.newLogin.role = 'customer';
      }
    );
  }

  newLoginBtn() {

  
    this.loginService.newLogin(this.newLogin).subscribe(data => {
      if (data == true) {
        sessionStorage.setItem('customer', JSON.stringify(this.newLogin));
        alert("Username Password added Successfully");
        this.router.navigate(['register']);
      }
      else
        this.status = "Account Not added !!!! Please try again";
    }, Error => {
      this.Error = "Server Error !!!! Please try again after some time"
    }
    );
  }
}
