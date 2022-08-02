import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { AccountDetails } from '../pojo/account-details';
import { CustomerDetails } from '../pojo/customer-details';

@Injectable({
  providedIn: 'root'
})

export class RegisterService {

  private baseURL: string = "http://192.168.1.63:8080/netbankingapi/";

  constructor(private http: HttpClient) { }

  addRegister(register: CustomerDetails): Observable<boolean> {
    return this.http.post<boolean>(this.baseURL + "customerdetails/addnew", register);
  }

  register(): Observable<CustomerDetails> {
    return this.http.get<CustomerDetails>(this.baseURL + "accountdetails/getallaccounts");
  }

  decline(accountDetails: AccountDetails): Observable<boolean> {
    return this.http.put<boolean>(this.baseURL + "accountdetails/updatestatus", accountDetails);
  }

  approve(accountDetails: AccountDetails): Observable<boolean> {
    return this.http.put<boolean>(this.baseURL + "accountdetails/updatestatus", accountDetails);
  }

  customerDecline(customerDetails: CustomerDetails): Observable<boolean> {
    return this.http.put<boolean>(this.baseURL + "customerdetails/updatestatus", customerDetails);
  }
  
  customerApproved(customerDetails: CustomerDetails): Observable<boolean> {
    return this.http.put<boolean>(this.baseURL + "customerdetails/updatestatus", customerDetails);
  }

}
