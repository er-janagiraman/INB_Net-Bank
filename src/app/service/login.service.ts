import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { CustomerDetails } from '../pojo/customer-details';
import { LoginDetails } from '../pojo/login-details';

@Injectable({
  providedIn: 'root'
})

export class LoginService {

  private baseURL: string = "http://192.168.1.63:8080/netbankingapi/logindetails/";
  private customerURL: string = "http://192.168.1.63:8080/netbankingapi/";

  constructor(private http: HttpClient) { }

  login(login: LoginDetails): Observable<LoginDetails> {
    return this.http.post<LoginDetails>(this.baseURL + "", login);
  }
  newLogin(newLogin: LoginDetails): Observable<boolean> {
    return this.http.post<boolean>(this.baseURL + "addnew", newLogin);
  }

  getNextUserId(): Observable<LoginDetails> {
    return this.http.get<LoginDetails>(this.baseURL + "getnextuserid");
  }

  getLoginData(userId: string): Observable<CustomerDetails> {
    return this.http.get<CustomerDetails>(this.customerURL + "customerdetailsbyuserid/" + userId);
  }

}
